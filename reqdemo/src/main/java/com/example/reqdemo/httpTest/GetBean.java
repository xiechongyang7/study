package com.example.reqdemo.httpTest;

import com.example.reqdemo.controller.TestModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/2/13 上午 11:54
 * @author xiechongyang
 */
public class GetBean {

    public static TestModel getBean(){
        TestModel testModel = new TestModel();

        List<String> list = new ArrayList<>();
        list.add("");
        list.add("ha");
        list.add("ma");
        list.add("la");
        list.add("pa");
        list.add(" ");
        list.add("");
        String[] shorts = new String[5];
        shorts[0] = "1";
        shorts[1] = "2";
        shorts[2] = "3";
        shorts[3] = "4";
        shorts[4] = "5";
        testModel.setMyStrArry(shorts);
        testModel.setStr(" this is test ");
        testModel.setI(1);
        testModel.setI2(2);
        testModel.setDou(3.0);
        testModel.setMyList(list);
        System.out.println(testModel.toString());
        return testModel;
    }


    public static void main(String[] arg){
        getBean();
    }
}
