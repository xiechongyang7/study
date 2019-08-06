package demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/8/2 下午 1:46
 * @author xiechongyang
 */
public class Example {




    public static void main(String[] arg) throws Exception {
        String filePath = input();
        List<String> strList = getStrLine(filePath);
        List<String> list = new ArrayList<>();
        List<String> getList = new ArrayList<>();
        List<String> setList = new ArrayList<>();
        String className = "className";

        for (int i = 0; i < strList.size(); i++) {
            String line = strList.get(i);
            if (!isNullStr(line)) {
                if(line.contains("get")&&line.contains("(")){
                    break;
                }
                if (line.contains("package")
                        || line.contains("import")
                        || line.contains("/")
                        || line.contains("@")
                        || line.contains("*")) {
                    continue;
                }

                if (line.contains("public")) {
                    if (line.contains("class")) {
                        className = line.split(" ")[2];
                        className = className.substring(0, 1).toUpperCase() + className.substring(1);
                        continue;
                    } else {
                        break;
                    }
                }

                int bankLast = line.lastIndexOf(" ");
                int lastStr = line.indexOf(";");
                String value = "";
                try {
                    value = line.substring(bankLast + 1, lastStr);
                } catch (Exception e) {
                    System.out.println(value + "出错了");
                    continue;
                }

                String fieldName = value.substring(0, 1).toUpperCase() + value.substring(1);
                getAndSet(line,className,value,fieldName,getList,setList);
                String printStr =  getExample(className,value,fieldName);
                list.add(printStr);

            }
        }

        System.out.println("---------------------------start");
        System.out.println("---------------------------set");
        for (String str : setList) {
            System.out.println(str);
        }
        System.out.println("---------------------------get");

        System.out.println("Integer startPageNum = accountAccounts.getStartPageNum();\n" +
                "Integer endPageNum = accountAccounts.getEndPageNum();\n" +
                "Date starTime = accountAccounts.getStarTime();\n" +
                "Date endTime = accountAccounts.getEndTime();");
        for (String str : getList) {
            System.out.println(str);
        }
//        System.out.println("*********************");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("if(isNotNull(starTime)){criteria.andCreateTimeGreaterThanOrEqualTo(starTime);}\n" +
                "if(isNotNull(endTime)){criteria.andCreateTimeLessThanOrEqualTo(endTime);}\n" +
                "if(isNotNull(startPageNum)){example.setLimitStart(startPageNum);}\n" +
                "if(isNotNull(endPageNum)){example.setLimitEnd(endPageNum);}\n" +
                "return example;");
        System.out.println("*********************end");
    }



    /**
     * 获取文件位置
     * @return
     */
    private static String input(){
        System.out.println("*********************start");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件位置：");
        String filePath = sc.nextLine();
        return filePath;
    }

    /**
     * 获取文件字符串行
     * @param filePath
     * @return
     */
    private static List<String> getStrLine(String filePath) throws Exception {
        File file = new File(filePath);
        List<String> strList;

        try {
            strList = FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("文件读取出错：");
        }

        if (strList.isEmpty()) {
            throw new Exception("没有读取到有效信息");
        }

        return strList;

    }
    /**
     * 判断是否为空
     *
     * @param str
     * @return 空 true
     */
    private static boolean isNullStr(String str) {
        return str.length() == 0 || "".equals(str) || str == null;
    }

    static boolean flag = true;
    private static String getExample(final String className,String value,String fieldName){
        StringBuilder builder = new StringBuilder();
        /**
         * 		AccountAccountsExample example = new AccountAccountsExample();
         * 		AccountAccountsExample.Criteria criteria = example.createCriteria();
         */
        if(flag){
            builder = new StringBuilder(className);
            builder.append("Example example = new ");
            builder.append(className);
            builder.append("Example();\n");
            builder.append(className);
            builder.append("Example.Criteria criteria = example.createCriteria();");
            builder.append("\n");
            flag = false;
        }


        /**
         * 		if(isNotNull(accountId)){criteria.andAccountIdEqualTo(accountId);}
         */
        builder.append("if(isNotNull(");
        builder.append(value);
        builder.append(")){criteria.and");
        builder.append(fieldName);
        builder.append("EqualTo(");
        builder.append(value);
        builder.append(");}");
        return builder.toString();
    }

    private static void getAndSet(String line,final String classNames,String value,String fieldName,List<String> getList,List<String> setList){

        String className = classNames.substring(0, 1).toLowerCase() + classNames.substring(1);
        String[] types = line.split(" ");
        String type  = types[types.length-2];

        if (line.contains("boolean") || line.contains("Boolean")) {
            String getMethodName = type +" "+ value + " = "+className + ".is" + fieldName + "();";
            getList.add(getMethodName);
            StringBuilder setMethodName = new StringBuilder(className);
            setMethodName.append(".set");
            setMethodName.append(fieldName);
            setMethodName.append("(");
            setMethodName.append(value);
            setMethodName.append(");");
            setList.add(String.valueOf(setMethodName));
            return;
        }


        String getMethodName = type + " " + value + " = "+className + ".get" + fieldName + "();";
        getList.add(getMethodName);
        StringBuilder setMethodName = new StringBuilder(className);
        setMethodName.append(".set");
        setMethodName.append(fieldName);
        setMethodName.append("(");
        setMethodName.append(value);
        setMethodName.append(");");
        setList.add(String.valueOf(setMethodName));
    }
}
