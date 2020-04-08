package com.tima.admin.util;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/*
*  @url请求地址
*  @param 请求参数类
*  @respEntity 返回数据 类型类
*  @methodFlag 请求方式  0 =POST , 1=GET
*
* */
@Slf4j
public class RestTemplateUtil {
    public static <T, K> ResponseEntity<K> getRequest(String url, T param, K respEntity, Integer methodFlag) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        HttpHeaders headers = new HttpHeaders();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<T> formEntity = new HttpEntity<T>(param, headers);
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        String paramStr = "";
        try {
            paramStr = JsonUtil.parseURLPair(param);
            if (!"".equals(paramStr) && paramStr != null)
                url += "?"+paramStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("转url参数："+url);
        ResponseEntity<K> res = null;

        for (int i = 0;i<3;i++){
            log.info("调用Ma接口：：：：请求第  "+i+"  次");
            try {
                res = restTemplate.exchange(url, methodFlag == 0 ? HttpMethod.POST : HttpMethod.GET, formEntity, (Class<K>) respEntity.getClass());
                if (res.getStatusCodeValue() == 200) {
                	log.info("--------------------   接口返回   -------------------");
                	log.info(JSON.toJSONString(res));
                	log.info(JSON.toJSONString("resBody--------"+res.getBody()));
                	break;
                }
            }catch (Exception e){
                log.info("接口调用报错：");
                log.info(e.toString());
            }
        }

        return res;
    }




    public static <T, K> ResponseEntity<K> NotificationPushXinGe(String url, T param, K respEntity, Integer methodFlag) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        HttpHeaders headers = new HttpHeaders();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<T> formEntity = new HttpEntity<T>(param, headers);
        RestTemplate restTemplate = new RestTemplate(requestFactory);

//        String paramStr = "";
//        try {
//            paramStr = JsonUtil.parseURLPair(param);
//            if (!"".equals(paramStr) && paramStr != null)
//                url += "?"+paramStr;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        log.info("转url参数："+url);
        ResponseEntity<K> res = null;
        log.info("推送地址："+url);
        for (int i = 0;i<3;i++){
            log.info("推送信息：：：请求第  "+i+"  次");
            try {
                res = restTemplate.exchange(url, methodFlag == 0 ? HttpMethod.POST : HttpMethod.GET, formEntity, (Class<K>) respEntity.getClass());
                if (res.getStatusCodeValue() == 200) {
	                log.info("--------------------   接口返回   -------------------");
	                log.info(JSON.toJSONString(res));
	                log.info(JSON.toJSONString(res.getBody()));
	                break;
                }
            }catch (Exception e){
                log.info("接口调用报错：");
                log.info(e.toString());
            }
        }

        return res;
    }




}
//    public static void main(String[] args) {
//        RestTemplateUtil rtu = new RestTemplateUtil();
//
//        entity e = new entity();
//        e.setIdType("VIN");
//        e.setIdValue("L34VMATxxxxxxx001");
//        e.setLatitude("39.9898651801215");
//        e.setLongitude("116.383723687066");
//        e.setBatterySOC(0);
//        e.setChargeType("10");
//        e.setDischargeRate(0);
//
//        respose res = new respose();
//        ResponseEntity<respose> ss = rtu.getRequest("http://114.115.182.59:31108/v1/parking/vehicle/external/parking/querychargingrate?spId=ETCP&parkId=1001211",e,res,0);
//        System.out.println(ss.getBody().getRespCode());
//        System.out.println(ss.getBody().getRespMsg());
//    }
//
//}
//
//@Getter
//@Setter
//class entity{
//    private String idType;
//
//    private String idValue;
//
//    private String longitude;
//
//    private String latitude;
//
//    private Integer batterySOC;
//
//    private Integer dischargeRate;
//
//    private String chargeType;
//}
//
//@Getter
//@Setter
//class respose{
//
//    private Integer respCode;
//    private String respMsg;
//
//
//}
