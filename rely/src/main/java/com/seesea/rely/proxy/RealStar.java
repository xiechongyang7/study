package com.seesea.rely.proxy;

/**
 * @description
 * @since JDK1.8
 * @createTime 2018/12/27 17:18
 * @author xiechongyang
 */
public class RealStar implements Star{
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
