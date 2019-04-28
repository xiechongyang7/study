package com.seesea.rely.proxy;

/**
 * @author xiechongyang
 * @description
 * @createTime 2018/12/27 17:18
 * @since JDK1.8
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("明星面谈");
    }

    @Override
    public void signContract() {
        System.out.println("明星签合同");
    }

    @Override
    public void bookTicket() {
        System.out.println("明星订票");
    }

    @Override
    public void sing() {
        System.out.println("明星唱歌");
    }

    @Override
    public void collectMoney() {
        System.out.println("明星收钱");
    }
}
