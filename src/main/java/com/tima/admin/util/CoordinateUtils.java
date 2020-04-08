package com.tima.admin.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CoordinateUtils {

    public static Map<String,BigDecimal> getRange(BigDecimal longitude, BigDecimal latitude){
        Map<String,BigDecimal> retMap = new HashMap<String, BigDecimal>();
        BigDecimal bd = new BigDecimal(0.03);

//        log.info("-------"+latitide.subtract(bd).setScale(6,   BigDecimal.ROUND_HALF_UP));
//        ro.setBottomLatitude(latitide.subtract(bd));
//        ro.setTopLatitude(latitide.add(bd));
//        ro.setRigthLongitude(longitide.add(bd));
//        ro.setLeftLongitude(longitide.subtract(bd));
        retMap.put("BottomLatitude",latitude.subtract(bd).setScale(6,   BigDecimal.ROUND_HALF_UP));
        retMap.put("TopLatitude",latitude.add(bd).setScale(6,   BigDecimal.ROUND_HALF_UP));
        retMap.put("RightLongitude",longitude.add(bd).setScale(6,   BigDecimal.ROUND_HALF_UP));
        retMap.put("LeftLongitude",longitude.subtract(bd).setScale(6,   BigDecimal.ROUND_HALF_UP));
        return retMap;
    }
}
