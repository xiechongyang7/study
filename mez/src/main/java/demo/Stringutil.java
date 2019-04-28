package demo;

import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Logger;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/4/8 下午 2:27
 * @since JDK1.8
 */
public class Stringutil {

//    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    /**
     * javaBean变成字符串
     *
     * @param obj
     * @return
     */
    public static String sortValue(Object obj) {
        String str = null;
        try {
            if (obj == null) {
                return str;
            }
            Class<?> clz = obj.getClass();
            Field[] declaredFields = clz.getDeclaredFields();
            List<String> list = new ArrayList<>();
            for (Field field : declaredFields) {
                String name = field.getName();
                if ("SIGN".equals(name.toUpperCase()) || "THIS$0".equals(name.toUpperCase()) || "SERIALVERSIONUID".equals(name.toUpperCase())) {
                    continue;
                }
                String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                Method declaredMethod = clz.getMethod(methodName);
                Object fieldValue = declaredMethod.invoke(obj);
                if (null == fieldValue || "".equals(fieldValue)) {
                    continue;
                }
                list.add(name + "=" + fieldValue.toString());
            }
            if (list.size() == 0) {
                return str;
            }
//            logger.info(list+"排序前");
            Collections.sort(list);
//            logger.info(list+"排序后");
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                stringBuilder.append("&").append(list.get(i));
            }
            str = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return str;
    }

    public static void main(String arg[]) {
        Person person = new Person();

        person.setAge(1);
        person.setHeight(2.0);
        person.setName("a");
        person.setSex("e");
        List<String> list = new ArrayList<>();
        list.add("z");
        list.add("x");
        list.add("c");
        person.setList(list);
        System.out.println(sortValue(person));

    }
}
