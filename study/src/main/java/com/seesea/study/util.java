package com.seesea.study;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/25 11:06
 * @Author xie
 */
public class util {

    //base64字符串转byte[]
    public static byte[] base64String2ByteFun(String base64Str){
        return Base64.decodeBase64(base64Str);
    }
    //byte[]转base64
    public static String byte2Base64StringFun(byte[] b) {
        return Base64.encodeBase64String(b);

    }
}
