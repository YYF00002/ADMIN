package com.tima.admin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 命名方法转换工具类
 * 
 * @author YYF 2018/7/30
 */
public class CaseNamed {
	
	private static Pattern linePattern = Pattern.compile("_(\\w)");

	/** 下划线转驼峰 */
	public static String toCamelCase(String str) {
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}


	private static Pattern humpPattern = Pattern.compile("[A-Z]");

	/** 驼峰转下划线*/
	public static String toUnderScoreCase(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
}
