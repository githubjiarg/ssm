package com.huawei.demo.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EncryptUtil {

    // 用于模拟数据库
    private static Map users = new HashMap();

    /**
     *  加密
     * @return
     */
    public static String encrypt(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte [] bytes = messageDigest.digest(str.getBytes());
        BigInteger bigInteger = new BigInteger(1,bytes);
        return bigInteger.toString(32);
    }

    /**
     *  md5加密
     * @return
     */
    public static String stringToMd5(String str){
        MessageDigest messageDigest = null;
        StringBuffer stringBuffer = new StringBuffer();
        try{
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Exception e){
            e.printStackTrace();
        }
        char [] chars = str.toCharArray();
        byte [] bytes = new byte[chars.length];
        for ( int i =0; i < chars.length; i++ ) {
            bytes[i] = (byte) chars[i];
        }
        byte [] md5Bytes = messageDigest.digest(bytes);
        for ( int i = 0; i < md5Bytes.length; i++ ) {
            int value = md5Bytes[i] & 0xff;
            if ( value < 16 ) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(value));
        }
        return stringBuffer.toString();
    }

    /**
     *  解密
     * @param str
     * @return
     */
    public static String decrypt(String str){
        char [] chars = str.toCharArray();
        for ( int i = 0; i < chars.length; i++ ) {
            chars[i] = (char) (chars[i] ^ 't');
        }
        return new String(chars);
    }

    public static String toMD5(String s){
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd','e', 'f'};
        try
        {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++)
            {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e)
        {
            return null;
        }
    }


    public static void main(String[] args){
        String password = "123456";
        System.out.println(toMD5("123456"));
        System.out.println("------------------------");
        String str = stringToMd5("123456");
        System.out.println("加密：" + str);
        System.out.println("解密：" + decrypt(("jiaruiguo787"))) ;
    }



}
