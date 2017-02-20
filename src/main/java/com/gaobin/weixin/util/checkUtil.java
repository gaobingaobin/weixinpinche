package com.gaobin.weixin.util;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/1.
 */
public class checkUtil {
    private static final String token = "gaobin";
    public static  boolean checkSignature(String signature, String timestamp, String nonce){
        String[] arr = new String[]{token,timestamp,nonce};
        Arrays.sort(arr);//排序
        StringBuffer content = new StringBuffer();
        for(int i = 0; i<arr.length; i++){
            content.append(arr[i]);
        }
        //sha1加密
        String temp = sha1Util.getSha1(content.toString());
        return temp.equals(signature);
    }
}
