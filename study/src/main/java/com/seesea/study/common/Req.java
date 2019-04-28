package com.seesea.study.common;


import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/13 11:55
 * @Author xie
 */
public class Req {
    private String channelId;
    private String firstChannelId;
    private String requestId;
    private String serviceId;

    @JsonIgnore
    public Result getResult() {
        Result result = new Result();
//        result.setReqId(reqId);
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getFirstChannelId() {
        return firstChannelId;
    }

    public void setFirstChannelId(String firstChannelId) {
        this.firstChannelId = firstChannelId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Req{");
        sb.append("channelId='").append(channelId).append('\'');
        sb.append(", firstChannelId='").append(firstChannelId).append('\'');
        sb.append(", requestId='").append(requestId).append('\'');
        sb.append(", serviceId='").append(serviceId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
