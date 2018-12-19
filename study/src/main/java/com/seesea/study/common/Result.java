package com.seesea.study.common;

import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/13 11:55
 * @Author xie
 */
public class Result {

    private String code;

    private String msg;

    private Rsp data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;

    }

    public Rsp getData() {
        return data;
    }

    public void setData(Rsp data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Result{");
        sb.append("code='").append(code).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}



//
//    public void setData(Object data) {
//        try{
//            if (data.get("code") != null && !"".equals(data.get("code"))) {
//                setCode(data.get("code").toString());
//                setMsg(data.get("msg").toString());
//            }else {
//                if(data.get("msg") != null && !"".equals(data.get("msg"))){
//                    setMsg(data.get("msg").toString());
//                }else {
//                    setCode("200");
//                }
//            }
//            this.data = data;
//        }catch (Exception e){
//            setCode("9999");
//            setMsg(String.format("{}","业务层返回参数有误"));
//            this.data = data;
//        }
//    }