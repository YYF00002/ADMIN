package com.tima.admin.aop;

import com.alibaba.fastjson.JSON;
import com.tima.admin.asyncTask.AsyncTask;
import com.tima.admin.dto.ServiceLogsDTO;
import com.tima.admin.util.CommentUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
/**
 * 记录请求和返回的log
 * auth J&J on 18/7/18
 */
@Aspect
@Component
@Slf4j
public class ServiceLogAspect {

	@Autowired
	private AsyncTask asyncTask;

	@Pointcut( "execution(* com.tima.*.web.*Controller.*(..))" )
	  public void saveLog() {
	   }
	  @Before("saveLog()")
	  public void doBefore(JoinPoint joinPoint) throws Throwable {
		  ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	      HttpServletRequest request = attributes.getRequest();
	      Map<String, String> headInfo = new HashMap<>();
          Enumeration<?> headerNames = request.getHeaderNames();
          while (headerNames.hasMoreElements()) {
              String key = (String) headerNames.nextElement();
              String value = request.getHeader(key);
              headInfo.put(key, value);
          }
	      // 记录下请求内容
          log.info("IP : " + request.getRemoteAddr());
          log.info("URL : " + request.getRequestURL().toString());
          log.info("HTTP_METHOD : " + request.getMethod());
		  log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
          log.info("ARGS : " + JSON.toJSONString(joinPoint.getArgs()));
          log.info("HEAD INFO : " + headInfo.toString());

		  ServiceLogsDTO serviceLogsDTO = new ServiceLogsDTO();
		  serviceLogsDTO.setIp(request.getRemoteAddr());
		  serviceLogsDTO.setUrl(request.getRequestURL().toString());
		  serviceLogsDTO.setHttpMethord(request.getMethod());
		  serviceLogsDTO.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		  serviceLogsDTO.setArgs(JSON.toJSONString(joinPoint.getArgs()));
		  serviceLogsDTO.setHeadInfo(headInfo.toString());
		  serviceLogsDTO.setTime(CommentUtil.getTime());
		  asyncTask.insertLogToMongo(serviceLogsDTO);
	  }
	  @AfterReturning(returning = "ret", pointcut = "saveLog()")
	  public void doAfterReturning(Object ret) throws Throwable {
		  log.info("service return toJsonString:" + JSON.toJSONString(ret));
	  }
}
