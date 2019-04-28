package com.seesea.rely.thread;

import org.slf4j.MDC;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 17:58
 * @Author xie
 */
abstract class LogMDC {
    String getMDC() {
        return MDC.get("reqNo");
    }
}
