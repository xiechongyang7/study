package com.seesea.rely.Base;

import org.springframework.util.StringUtils;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 11:11
 * @Author xie
 */
public class Test {


    public static void main(String arg[]) {
        int feeCount;
        String feeCountStr = null + "";

        System.out.println("null".equals(feeCountStr));
        if (!("".equals(feeCountStr))) {
            feeCount = Integer.valueOf(feeCountStr);
            System.out.println("dd");
        }
    }
}
