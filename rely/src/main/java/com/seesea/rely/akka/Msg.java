package com.seesea.rely.akka;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 15:57
 * @Author xie
 */
public class Msg {

    private String content = "apple";

    public Msg(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


