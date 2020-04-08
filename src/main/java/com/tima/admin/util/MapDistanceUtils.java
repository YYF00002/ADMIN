package com.tima.admin.util;

public class MapDistanceUtils {

	/**  地球半径  **/
	private static final double EARTH_RADIUS = 6371.004;

	/**
	 * 计算两点之间距离
	 * 
	 * @param startLong
	 * @param startLat
	 * @param endLong
	 * @param endLat
	 * 
	 * @return 米
	 */
	public static double getDistance(double startLong, double startLat, double endLong, double endLat) {

		double lon1 = (Math.PI / 180) * startLong;
		double lon2 = (Math.PI / 180) * endLong;
		double lat1 = (Math.PI / 180) * startLat;
		double lat2 = (Math.PI / 180) * endLat;

		// 两点间距离 km
		double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * MapDistanceUtils.EARTH_RADIUS;

		// 两点之间距离 m
		return d * 1000;
	}
}