package com.seesea.study.common;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/13 17:27
 * @Author xie
 */
public class BaseException extends Exception {

    public String errCode;

    public BaseException() {
        super();
    }

    public BaseException(BaseException e) {
        super(e.getMessage());
        this.errCode = e.errCode;
    }

    public BaseException(ErrorEnum e) {
        super(e.getMsg());
        this.errCode = e.getCode();
    }

}
