package com.tima.admin.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MapUtils {

	private static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

	/**
	 * 对double类型数据保留小数点后多少位 高德地图转码返回的就是 小数点后6位，为了统一封装一下
	 * 
	 * @param digit
	 *            位数
	 * @param in
	 *            输入
	 * @return 保留小数位后的数
	 */
	static double dataDigit(int digit, double in) {
		return new BigDecimal(in).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 将火星坐标转变成百度坐标
	 * 
	 * @param lngLat_gd
	 *            火星坐标（高德、腾讯地图坐标等）
	 * @return 百度坐标
	 */
	public static double gd_tobd_lng(double lng, double lat) {
		double x = lng, y = lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		return dataDigit(6, z * Math.cos(theta) + 0.0065);
	}

	public static double gd_tobd_lat(double lng, double lat) {
		double x = lng, y = lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		return dataDigit(6, z * Math.sin(theta) + 0.006);
	}

	/**
	 * 将百度坐标转变成火星坐标
	 * 
	 * @param lngLat_bd
	 *            百度坐标（百度地图坐标）
	 * @return 火星坐标(高德、腾讯地图等)
	 */
	public static double bd_togd_lng(double lng, double lat) {
		double x = lng - 0.0065, y = lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		return dataDigit(6, z * Math.cos(theta));
	}

	public static double bd_togd_lat(double lng, double lat) {
		double x = lng - 0.0065, y = lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		return dataDigit(6, z * Math.sin(theta));
	}

	public static void main(String[] args) {
		Map<String, Double> map = new HashMap<String, Double>();
		Map<String, Double> result = new HashMap<String, Double>();
		for (int i = 0; i < 100000; i++) {
			double r_lng = 113.331246;
			double r_lat = 23.151779;
			map.put("lng" + i, r_lng);
			map.put("lat" + i, r_lat);
		}
		System.out.println("转换开始：" + System.currentTimeMillis());
		for (int i = 0; i < 100000; i++) {
			double lng = bd_togd_lng(map.get("lng" + i), map.get("lat" + i));
			double lat = bd_togd_lat(map.get("lng" + i), map.get("lat" + i));
			result.put("lng" + i, lng);
			result.put("lat" + i, lat);
		}
		System.out.println("处理完毕：" + System.currentTimeMillis());
	}
}
