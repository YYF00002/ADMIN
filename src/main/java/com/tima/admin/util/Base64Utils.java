package com.tima.admin.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class Base64Utils {

    private static Base64 base641=new Base64();


    public static String encode(String str){
        if(StringUtil.getString_TrimZeroLenAsNull(str)==null){
            return  null;
        }
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = base641.encodeToString(bytes);
        return result;
    }

    public static String decode(String str){
        if(StringUtil.getString_TrimZeroLenAsNull(str)==null){
            return  null;
        }
        String result=null;
        try {
            result = new String(base641.decode(str), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }


}
