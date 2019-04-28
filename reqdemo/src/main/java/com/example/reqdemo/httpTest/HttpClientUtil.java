package com.example.reqdemo.httpTest;

import com.example.reqdemo.controller.TestArray;
import com.example.reqdemo.controller.TestModel;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/2/13 上午 11:18
 * @since JDK1.8
 */
public class HttpClientUtil {
    static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static void main(String arg[]) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        TestModel testModel = GetBean.getBean();


//        Map map = BeanUtils.describe(testModel);
        Map<String, Object> map = PropertyUtils.describe(testModel);
//
//        Short[] shorts = new Short[5];
//        shorts[0] = 1;
//        shorts[1] = 2;
//        shorts[2] = 3;
//        shorts[3] = 4;
//        shorts[4] = 5;
//        map.put("shorts",shorts);
//        Map<String, Object> map = new HashMap<>();
//        map.put("str", testModel.getStr());
//        map.put("i", testModel.getI());
//        map.put("i2", testModel.getI2());
//        map.put("dou", testModel.getDou());
//        map.put("myList", testModel.getMyList());
//        List<Short> shorts = new ArrayList<>();
//        shorts.add(Short.valueOf("1"));
//        shorts.add(Short.valueOf("2"));
//        shorts.add(Short.valueOf("3"));

//        map.put("shorts", shorts);
        System.out.println(doPost2("http://localhost:8080/test/form", map));

//        Map map = new HashMap();
//        List<Short> shorts = new ArrayList<>();
//        shorts.add(Short.valueOf("1"));
//        shorts.add(Short.valueOf("2"));
//        shorts.add(Short.valueOf("3"));

//        Short[] shorts = new Short[5];
//        shorts[0] = 1;
//        shorts[1] = 2;
//        shorts[2] = 3;
//        shorts[3] = 4;
//        shorts[4] = 5;
//        String[] shorts = new String[2];
//        shorts[0] = "1";
//        shorts[1] = "2";
//        map.put("list",shorts);
//        System.out.println(http("http://localhost:8080/test/formAndFile", map));
//        TestArray array = new TestArray();
//        List<Short> shorts = new ArrayList<>();
//        shorts.add(Short.valueOf("1"));
//        shorts.add(Short.valueOf("2"));
//        shorts.add(Short.valueOf("3"));
//        array.setList(shorts);
//        RestTemplate restTemplate = new RestTemplate();
//        List<String> list = new ArrayList<>();
//        list.add("");
//        list.add("ha");
//        list.add("ma");
//        list.add("la");
//        list.add("pa");
//        list.add(" ");
//        list.add("");
//
//        Map<String, Object> map2 = PropertyUtils.describe(testModel);
//
//
//
//        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        map.setAll(map2);
//        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
////        String entity = restTemplate.postForObject("http://localhost:8080/test/formAndFile",array,String.class);
//        ResponseEntity entity = restTemplate.postForEntity("http://localhost:8080/test/form",request,String.class);
//        System.out.println(entity.getBody().toString());

    }


    private static String doPost2(String url, Map params) {
        BufferedReader in = null;
        HttpClient client = null;
        HttpPost request = null;
        try {

            client = HttpClientBuilder.create().build();
            request = new HttpPost(url);

            //设置参数
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            for (Iterator iterator = params.keySet().iterator(); iterator.hasNext(); ) {
                String name = (String) iterator.next();
                String value = String.valueOf(params.get(name));
                nameValuePairs.add(new BasicNameValuePair(name, value));
            }

            //设置请求的报文头部的编码
            request.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
            //设置期望服务端返回的编码
            request.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));
            request.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            logger.info("请求" + request.getEntity().toString());
            HttpResponse response = client.execute(request);
            logger.info("响应信息 response http status: " + response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                logger.info("请求成功" + response.toString());
                return EntityUtils.toString(response.getEntity());
            } else {
                for (org.apache.http.Header header : response.getAllHeaders()) {
                    logger.info("响应信息 response header: " + header.toString());
                }
                return null;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (request != null) {
                    request.releaseConnection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

//    /**
//     * POST请求方法;请求类型：application/x-www-form-urlencoded
//     * @Author:
//     * @param url   请求地址
//     * @param map  传的参数封装
//     * @param charset  字符编码
//     * @return: java.lang.String    返回结果
//     * @Date: 2018/5/2 上午10:06
//     */
//    public static String doPost(String url,Map<String,Object> map,String charset){
//        HttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = null;
//        try{
//            httpClient = new SSLClient();
//            httpPost = new HttpPost(url);


    //        if(_params != null) {
//            NameValuePair[] pairs = new NameValuePair[_params.size()];//纯参数了，键值对
//            int i = 0;
//            for (Map.Entry<String, Object> entry : _params.entrySet()) {
//                pairs[i] = new NameValuePair(entry.getKey(), String.valueOf(entry.getValue()));
//                i++;
//            }
//            method.addParameters(pairs);
//        }
//
//            //设置参数
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
//            Iterator iterator = map.entrySet().iterator();
//            while(iterator.hasNext()){
//                Map.Entry<String,String> elem = (Map.Entry<String, String>) iterator.next();
//                list.add(new BasicNameValuePair(elem.getKey(),String.valueOf(elem.getValue())));
//            }
//            if(list.size() > 0){
//                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
//                httpPost.setEntity(entity);
//            }
//            HttpResponse response = httpClient.execute(httpPost);
//            if(response != null){
//                HttpEntity resEntity = response.getEntity();
//                if(resEntity != null){
//                    result = EntityUtils.toString(resEntity,charset);
//                }
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//
//    public static String http(String url, Map<String, String> params) {
//        URL u = null;
//        HttpURLConnection con = null;
//        // 构建请求参数
//        StringBuffer sb = new StringBuffer();
//        if (params != null) {
//            for (Map.Entry<String, String> e : params.entrySet()) {
//                sb.append(e.getKey());
//                sb.append("=");
//                sb.append(e.getValue());
//                sb.append("&");
//            }
//            sb.substring(0, sb.length() - 1);
//        }
//        System.out.println("send_url:" + url);
//        System.out.println("send_data:" + sb.toString());
//        // 尝试发送请求
//        try {
//            u = new URL(url);
//            con = (HttpURLConnection) u.openConnection();
//            //// POST 只能为大写，严格限制，post会不识别
//            con.setRequestMethod("POST");
//            con.setDoOutput(true);
//            con.setDoInput(true);
//            con.setUseCaches(false);
//            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
//            osw.write(sb.toString());
//            osw.flush();
//            osw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (con != null) {
//                con.disconnect();
//            }
//        }
//
//        // 读取返回内容
//        StringBuffer buffer = new StringBuffer();
//        try {
//            //一定要有返回值，否则无法把请求发送给server端。
//            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
//            String temp;
//            while ((temp = br.readLine()) != null) {
//                buffer.append(temp);
//                buffer.append("\n");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return buffer.toString();
//    }


}
