package com.seesea.study.model;

import com.seesea.study.common.Req;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/13 13:54
 * @Author xie
 */
public class Heihei extends Req {

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Heihei{");
        sb.append("i=").append(i);
        sb.append('}');
        return sb.toString();
    }
}
