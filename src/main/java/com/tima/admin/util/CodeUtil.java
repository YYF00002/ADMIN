package com.tima.admin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class CodeUtil {

	// /**
	// * 生成租车订单的code
	// * @return
	// */
	// public static String generateForReservationOrder() {
	// String prefix = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	// return "DDR" + prefix + RandomStringUtils.randomNumeric(5);
	// }
	/**
	 * 10位数的序列号，长度不够前面自动补零
	 * 
	 * @param value
	 * @return
	 */
	public static String generateSeq(Integer value) {
		return String.format("%010d", value);
	}

//	/**
//	 * user_base_information 表
//	 * 
//	 * @return
//	 */
//	public static String generateForUBS() {
//		String prefix = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		return "UBS" + prefix + RandomStringUtils.randomNumeric(5);
//	}
//	
//	/**
//	 * user_address 表
//	 * 
//	 * @return
//	 */
//	public static String generateForUAdress() {
//		String prefix = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		return "UADDRESS" + prefix + RandomStringUtils.randomNumeric(5);
//	}
//	/**
//	 * image_relation 表
//	 * 
//	 * @return
//	 */
//	public static String generateForImage() {
//		String prefix = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		return "IMAGE" + prefix + RandomStringUtils.randomNumeric(5);
//	}
}
