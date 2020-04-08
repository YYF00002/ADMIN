package com.tima.admin.util;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class C3Util {

	// // URI
	// @Value("${c3.config.uri}")
	// private static String API;
	// // APPKEY
	// @Value("${c3.config.appkey}")
	// private static String APPKEY;
	// // 秘钥
	// @Value("${c3.config.key}")
	// private static String KEY;

	// 测试
	// public final static String API = "http://c3uat.timanetwork.cn/rcs/v1";
	// public final static String APPKEY = "br5OYGBbAbKrX8u";
	// public final static String KEY = "YneVgYiuFq358UJ";

	// 正式
	public final static String API = "http://c3uat.timanetwork.cn/basebiz/v1";
	public final static String APPKEY = "jOGYETjM3WvG79G";
	public final static String KEY = "RpJ1yvkOywYLUdO";
	//C3新接口
	
	/**
	 * 品牌管理API
	 */
	public final static String BRANDS_URL =  API + "/manage/brands";
	
	
	
    //end C3新接口
/*	public final static String MAKERS_URL = API + "/manage/makers";
	public final static String MAKERS_ALL_URL = API + "/manage/makers/all";
	public final static String MAKERS_PAGE_URL = API + "/manage/makers/page";
	public final static String BRANDS_URL = API + "/manage/brands";
	public final static String BRANDS_ALL_URL = API + "/manage/brands/all";
	public final static String BRANDS_LIST_URL = API + "/manage/brands/list";
	public final static String BRANDS_PAGE_URL = API + "/manage/brands/page";
	public final static String SERIES_URL = API + "/manage/series";
	public final static String SERIES_ALL_URL = API + "/manage/series/all";
	public final static String SERIES_LIST_URL = API + "/manage/series/list";
	public final static String SERIES_PAGE_URL = API + "/manage/series/page";
	public final static String MODELS_URL = API + "/manage/models";
	public final static String MODELS_ALL_URL = API + "/manage/models/all";
	public final static String MODELS_LIST_URL = API + "/manage/models/list";
	public final static String MODELS_PAGE_URL = API + "/manage/models/page";
	public final static String MODELS_PIC_URL = API + "/manage/models/pic";
	public final static String MODELS_PIC_DOWNLOAD_URL = API + "/manage/models/pic/download";
	public final static String MODELS_PIC_LIST_URL = API + "/manage/models/pic/list";
	public final static String GATEWAYS_URL = API + "/manage/gateWays";
	public final static String GATEWAYS_ALL_URL = API + "/manage/gateWays/all";
	public final static String GATEWAYS_PAGE_URL = API + "/manage/gateWays/page";
	public final static String SERVICEITEMS_URL = API + "/manage/serviceItems";
	public final static String SERVICEITEMS_PAGE_URL = API + "/manage/serviceItems/page";
	public final static String TBOXMODELS_URL = API + "/manage/tBoxModels";
	public final static String TBOXMODELS_ALL_URL = API + "/manage/tBoxModels/all";
	public final static String TBOXMODELS_PAGE_URL = API + "/manage/tBoxModels/page";
	public final static String VEHICLES_URL = API + "/manage/vehicles";
	public final static String VEHICLES_PAGE_URL = API + "/manage/vehicles/page";
	public final static String LOCK_URL = API + "/control/lock";
	public final static String UNLOCK_URL = API + "/control/unlock";
	public final static String POWERON_URL = API + "/control/powerOn";
	public final static String POWEROFF_URL = API + "/control/powerOff";
	public final static String STARTFLASH_URL = API + "/control/startFlash";
	public final static String STOPFLASH_URL = API + "/control/stopFlash";
	public final static String STARTHONK_URL = API + "/control/startHonk";
	public final static String STOPHONK_URL = API + "/control/stopHonk";
	public final static String TRACE_URL = API + "/control/trace";
	public final static String CARINFO_URL = API + "/manage/report/carinfo";
	public final static String HISTORY_URL = API + "/manage/report/history/carinfo";
	public final static String PROVIDE_URL = API + "/manage/serviceProvider";*/

	public static String getMD5(String message) {
		String md5str = "";
		try {
			// 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");

			// 2 将消息变成byte数组
			byte[] input = message.getBytes();

			// 3 计算后获得字节数组,这就是那128位了
			byte[] buff = md.digest(input);

			// 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
			md5str = bytesToHex(buff);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return md5str;
	}

	/**
	 * 二进制转十六进制
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		// 把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];

			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString().toUpperCase();
	}

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("msg")) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}

	/**
	 * 签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param key
	 *            密钥
	 * @return 签名结果
	 */
	public static String sign(String text) {
		String key = KEY;
		text = text + "&key=" + key;

		return DigestUtils.md5Hex(getContentBytes(text)).toUpperCase();
	}

	/**
	 * @param content
	 * @return
	 */
	private static byte[] getContentBytes(String content) {
		try {
			return content.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,");
		}
	}

	public static String getSign(Map<String, String> params) {
		// 过滤空值、sign与sign_type参数
		Map<String, String> sParaNew = paraFilter(params);
		// 获取待签名字符串
		String preSignStr = createLinkString(sParaNew);
		return sign(preSignStr);
	}

	// get请求url不包含参数，参数以map形式传入
	public static Map<String, Object> getRequest(String url, Map<String, String> params) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());

		RestTemplate restTemplate = new RestTemplate();
		String resultMap;
		try {
			String _url = url + "?" + C3Util.createLinkString(params);
			resultMap = restTemplate.getForObject(_url, String.class);
			System.out.println(resultMap);
			Map<String, Object> map = JsonUtil.jsonToMap(resultMap);
			return map;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	// post请求url中包含appKey，timestamp，sign参数，params中车辆参数参与验签，存在body中
	public static Map<String, Object> postRequest(String url, Map<String, String> params) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		HttpEntity<String> formEntity = new HttpEntity<>(JsonUtil.pojoToJson(params), headers);

		RestTemplate restTemplate = new RestTemplate();
		String resultMap;
		try {
			resultMap = restTemplate.postForObject(url, formEntity, String.class);
			Map<String, Object> map = JsonUtil.jsonToMap(resultMap);
			System.out.println(map);
			return map;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	// put请求体格式必须为application/json
	public static Map<String, Object> putRequest(String url, Map<String, String> params) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());

		RestTemplate restTemplate = new RestTemplate();
		String resultMap;
		try {
			URI uri = new URI(url);
			RequestEntity<Map<String, String>> requestEntity = new RequestEntity<Map<String, String>>(params, HttpMethod.PUT, uri);
			ResponseEntity<String> exchange = restTemplate.exchange(requestEntity, String.class);
			resultMap = exchange.getBody();
			Map<String, Object> map = JsonUtil.jsonToMap(resultMap);
			System.out.println(map);
			return map;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	// delete参数都放在url中
	public static Map<String, Object> deleteRequest(String url, Map<String, String> params) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());

		RestTemplate restTemplate = new RestTemplate();
		String resultMap;
		try {
			URI uri = new URI(url);
			RequestEntity<Map<String, String>> requestEntity = new RequestEntity<Map<String, String>>(params, HttpMethod.DELETE, uri);
			ResponseEntity<String> exchange = restTemplate.exchange(requestEntity, String.class);
			resultMap = exchange.getBody();
			Map<String, Object> map = JsonUtil.jsonToMap(resultMap);
			System.out.println(map);
			return map;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public static String getCurrentTimeMillis() {
		return "" + System.currentTimeMillis();
	}
	public static void main(String args[]) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("makerNo", "");
		params.put("appKey", C3Util.APPKEY);
		params.put("timestamp", C3Util.getCurrentTimeMillis());
		params.put("sign", C3Util.getSign(params));
		Map<String, Object> responseMap = C3Util.getRequest(C3Util.BRANDS_URL, params);
		List<Map<String, Object>> mapList = (List<Map<String, Object>>) responseMap.get("list");
		
		for (Map<String, Object> map : mapList) {			
		System.out.println((String) map.get("no"));
		System.out.println((String) map.get("name"));
		System.out.println((String) map.get("makerNo"));
		System.out.println((String) map.get("makerName"));
		
		}
	/*	Map<String, String> params = new HashMap<String, String>();
		params.put("vin", "1111111");

		String timestamp = C3Util.getCurrentTimeMillis();

		Map<String, String> checkParams = new HashMap<String, String>();
		checkParams.put("appKey", C3Util.APPKEY);
		checkParams.put("timestamp", timestamp);
		checkParams.putAll(params);

		Map<String, String> urlParams = new HashMap<String, String>();
		urlParams.put("appKey", C3Util.APPKEY);
		urlParams.put("timestamp", timestamp);
		urlParams.put("sign", C3Util.getSign(checkParams));
		String url = C3Util.LOCK_URL + "?" + C3Util.createLinkString(urlParams);

		Map<String, Object> responseMap = C3Util.postRequest(url, params);

		// 如果返回结果为false，打印签名信息
		String flag = (String)responseMap.get("flag");*/
		
		//System.out.println(ReservationOrderStatus.OPEN);
		
	}

}
