package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/23 上午 9:52
 * @author xiechongyang
 */
public class Main {


    /**
     * 1 hashCode
     * 2 hashMap
     *
     */

    public static void main(String[] arg){

        Map<String,Integer> map = new HashMap<>();
        map.put("q",1);
        map.put("w",2);
        map.put("e",3);
        map.put("r",4);

        System.out.println("PUT---" + map.get("q"));
        System.out.println("PUT---" + map.get("w"));
        System.out.println("PUT---" + map.get("e"));
        System.out.println("PUT---" + map.get("r"));
        System.out.println(map.size());

        map.put("q",5);
        System.out.println("PUT REPEAT---" + map.get("q"));
        System.out.println(map.size());

        map.remove("q");
        System.out.println("REMOVE---" + map.get("q"));
        System.out.println(map.size());


        IMap<Integer> myMap = new MyMap<>(2);
        myMap.put("q",1);
        myMap.put("w",2);
        myMap.put("e",3);
        myMap.put("r",4);

        System.out.println("PUT---" + myMap.get("q"));
        System.out.println("PUT---" + myMap.get("w"));
        System.out.println("PUT---" + myMap.get("e"));
        System.out.println("PUT---" + myMap.get("r"));
        System.out.println(myMap.getLength());

        myMap.put("q",5);
        System.out.println("PUT REPEAT---" + myMap.get("q"));
        System.out.println(myMap.getLength());

        myMap.remove("q");
        System.out.println("REMOVE---" + myMap.get("q"));
        System.out.println(myMap.getLength());

    }

}
