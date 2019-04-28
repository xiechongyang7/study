package com.example.reqdemo.test;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/2/13 下午 6:11
 * @since JDK1.8
 */
public class test {

    public static void main(String[] arg) {
        Short[] shorts = new Short[5];
        shorts[0] = 1;
        shorts[1] = 2;
        shorts[2] = 3;
        shorts[3] = 4;
        shorts[4] = 5;
        short s = 1;
        String a = String.valueOf(shorts);
        System.out.println(a);
    }
}
