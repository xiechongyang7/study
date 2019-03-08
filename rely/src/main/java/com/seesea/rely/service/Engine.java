package com.seesea.rely.service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @description
 * @since JDK1.8
 * @createTime 2018/12/29 10:17
 * @author xiechongyang
 */
public class Engine {

    /**
     * 运行JS基本函数
     */
    public static void jsFunction() {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("javascript");
        try {
            String script = "function say(name){ return 'hello,'+name; }";
            se.eval(script);
            Invocable inv2 = (Invocable) se;
            String res = (String) inv2.invokeFunction("say", "test");
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String arg[]){
        jsFunction();
    }
}
