package com.seesea.study.common;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/13 17:29
 * @Author xie
 */
public enum  ErrorEnum {

    ERR_0000("0000","hah"),
    ERR_0001("0001","aTypTAIWAN"),
    ERR_0002("0002","Type"),
    ERR_0003("0003","SSPORT");


    private String code;
    private String msg;
    ErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}
