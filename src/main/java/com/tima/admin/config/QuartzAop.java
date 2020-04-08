package com.tima.admin.config;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.tima.admin.util.WebToolUtils;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
@Aspect
@Component
@Slf4j
public class QuartzAop {
	@Autowired
    private RedisTemplate<Object, Object> redisTemplate;
	@Value("${server.port}")
	private String serverPort;
	public boolean checkStatus(String lockKey){
	        String key =lockKey; 
	        try {
	            // 这个接口必然是并发的，所以加分布式锁
	            while (true) {
	                // 一秒的超时时间
	                boolean lock = checkLock(key,1);
	                if (lock) {
	                    // 获取到锁，才能跳出
	                    break;
	                }
	            }
	            String ip="";
	        	try {
	        		ip = WebToolUtils.getLocalIP();
	        	} catch (UnknownHostException e) {	        		
	        		log.error(e.getMessage());
	        		return false;
	        	} catch (SocketException e) {	        		
	        		log.error(e.getMessage());
	        		return false;
	        	}
	            String ipAndPort = ip+":"+serverPort;	      
	            // 获取服务器上的工作ip
	            String currentIpAndPort = (String)redisTemplate.opsForValue().get(key);
	            log.info("缓存服务器上面的key值"+key);
	            log.info("缓存器上面的工作ip"+currentIpAndPort);
	            log.info("本服务器ip"+ipAndPort);
	            // 如果为空的时候，设置进去
	            if(currentIpAndPort == null){
	                //RedisUtil.setex(key, ip, 10);
	            	redisTemplate.opsForValue().set(key, ipAndPort, 10, TimeUnit.SECONDS);
	                return true;
	            }
	            // 就是当前机器，则返回true
	            if(currentIpAndPort.equals(ipAndPort)){
	                return true;
	            }else{
	            	 log.info("没有得到执行权");
	                return false;
	               
	            }
	        } catch (Exception e) {
	        	log.info("没有得到执行权");
	            log.error(e.getMessage());
	            return false;
	        }
	    }
	    
	    @Around("@annotation(org.springframework.scheduling.annotation.Scheduled)")
	    public void around(ProceedingJoinPoint jp) throws Throwable{
	        if(checkStatus("schedular_root:admin:"+jp.getSignature().getName())){
	            String ip = WebToolUtils.getLocalIP();
	            log.info("现在正在执行"+jp.getSignature()+":"+ip);	 
	            log.info("执行方法名"+jp.getSignature().getName());
	            jp.proceed();
	            redisTemplate.delete("lock:schedular_root:admin:"+jp.getSignature().getName());
	        }
	    }
	    
	

	public  boolean checkLock(String key,long second) {
	  
	  String lockKey = "lock:" + key;
	  try {
	     log.info("锁在加锁之前"+(String)redisTemplate.opsForValue().get(lockKey));
	   // 1表示之前不存在，设置成功
	   if (StringUtils.isBlank((String)redisTemplate.opsForValue().get(lockKey))) {
	    // 设置有限期
		   redisTemplate.expire(lockKey, second, TimeUnit.SECONDS);
		   log.info("锁在加锁之后"+(String)redisTemplate.opsForValue().get(lockKey));
	    return true;
	   } else {
	    // 50毫秒的延迟，避免过多请求
		  log.info("定时任务延迟50毫秒");
	    try {
	     Thread.sleep(50L);
	    } catch (InterruptedException e) {
	     log.error(e.getMessage());
	    }
	    return false;
	   }

	  } catch (Exception e) {
	   log.error(e.getMessage());
	   return false;
	  }
	}
}
