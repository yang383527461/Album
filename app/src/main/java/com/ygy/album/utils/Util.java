package com.ygy.album.utils;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2017/10/13.
 */

public class Util {
    /**
     * 登录账号MD5加密
     * @param s
     * @return
     */
    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final  static boolean isSame(String str1, String str2){
        if(str1.equals(str2)){
            return true;
        }
        return false;
    }

    public final  static boolean isEmpty(String str){
        if(str.equals("") || str.length() == 0) {
            return true;
        }
        return false;
    }
}
