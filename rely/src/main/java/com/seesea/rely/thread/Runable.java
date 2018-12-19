package com.seesea.rely.thread;

import org.slf4j.MDC;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 17:58
 * @Author xie
 */
public abstract class Runable extends LogMDC implements Runnable {

    final String loginfo = getMDC();

    @Override
    public void run() {
        star();
        constRun();
        end();
    }

    public abstract void constRun();

    private void star() {
        MDC.put("reqNo",loginfo);
    }
    private void end() {
        MDC.remove("reqNo");
    }
}
