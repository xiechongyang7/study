package com.study.studyredislock.lock;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/28 下午 3:13
 * @author xiechongyang
 */
public interface IDistributedLock {

    static final long TIMEOUT_MILLIS = 5000;

    static final int RETRY_TIMES = Integer.MAX_VALUE;

    static final long SLEEP_MILLIS = 500;

    boolean lock(String key);

    boolean lock(String key, int retryTimes);

    boolean lock(String key, int retryTimes, long sleepMillis);

    boolean lock(String key, long expire);

    boolean lock(String key, long expire, int retryTimes);

    boolean lock(String key, long expire, int retryTimes, long sleepMillis);

    boolean releaseLock(String key);
}
