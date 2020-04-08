package com.tima.admin.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tima.admin.vo.UserBaseInformationVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 公共的工具类
 * @author YYF
 *2018/8/1
 */

@Slf4j
public class CommentUtil {


	public static String createNo() {
		return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + RandomStringUtils.randomNumeric(5);
	}
	
	/**
	 * 获得UUID
	 * @return UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 获得当前时间 yyyy-MM-dd HH:mm:ss
	 * @return time
	 */
	public static String getTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
	}


	/**
	 * 版本号比较
	 *
	 * @param v1
	 * @param v2
	 * @return 0代表相等，1代表左边大，-1代表右边大
	 *
	 */
	public static int compareVersion(String v1, String v2) {
		if (v1.equals(v2)) {
			return 0;
		}
		String[] version1Array = v1.split("[._]");
		String[] version2Array = v2.split("[._]");
		int index = 0;
		int minLen = Math.min(version1Array.length, version2Array.length);
		long diff = 0;

		while (index < minLen
				&& (diff = Long.parseLong(version1Array[index])
				- Long.parseLong(version2Array[index])) == 0) {
			index++;
		}
		if (diff == 0) {
			for (int i = index; i < version1Array.length; i++) {
				if (Long.parseLong(version1Array[i]) > 0) {
					return 1;
				}
			}

			for (int i = index; i < version2Array.length; i++) {
				if (Long.parseLong(version2Array[i]) > 0) {
					return -1;
				}
			}
			return 0;
		} else {
			return diff > 0 ? 1 : -1;
		}
	}

	/**
	 * 手机号处理  隐藏中间四位
	 * @param phone
	 * @return
	 */
	public  static  String dealPhone(String phone){
		return phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
	}


    /**
     * 从token中获得用户信息
     * @param
     * @return
     */
    public  static UserBaseInformationVO getUser(){
        String user= null;
        try {
            user = URLDecoder.decode(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
					.getHeader("timaTokenDecrypt"), "UTF-8");
            log.info(user);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        log.info("userUtil: "+user);
		UserBaseInformationVO userBaseInformationVO = JsonUtil.jsonToPojo(user, new TypeReference<UserBaseInformationVO>() {
        });

        return userBaseInformationVO;
    }


}
