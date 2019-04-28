package com.seesea.study.util;

import org.apache.commons.net.util.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/4/8 下午 1:47
 * @since JDK1.8
 */
public class HmacUtil {


    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    public static byte[] HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
        byte[] data = encryptKey.getBytes(ENCODING);
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_NAME);
        //用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(ENCODING);
        //完成 Mac 操作
        return mac.doFinal(text);
    }

//    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
//
//    /**
//     * 使用 HMAC-SHA1 签名方法对data进行签名
//     *
//     * @param data 被签名的字符串
//     * @param key  密钥
//     * @return 加密后的字符串
//     */
//    public static String genHMAC(String data, String key) {
//        byte[] result = null;
//        try {
//            //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
//            SecretKeySpec signinKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
//            //生成一个指定 Mac 算法 的 Mac 对象
//            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
//            //用给定密钥初始化 Mac 对象
//            mac.init(signinKey);
//            //完成 Mac 操作
//            byte[] rawHmac = mac.doFinal(data.getBytes());
//            result = Base64.encodeBase64(rawHmac);
//
//        } catch (NoSuchAlgorithmException e) {
//            System.err.println(e.getMessage());
//        } catch (InvalidKeyException e) {
//            System.err.println(e.getMessage());
//        }
//        if (null != result) {
//            return new String(result);
//        } else {
//            return null;
//        }
//    }


    public static void main(String[] str) {
        try {

            Map<String, Object> map = new HashMap<>();
            map.put("", "");


            String str1 = new String(HmacSHA1Encrypt("hahaah", "key"));
            System.out.println(HmacSHA1Encrypt("hahaah", "key").toString());

//            System.out.println(genHMAC("hahaah","key"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
