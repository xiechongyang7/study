package com.example.reqdemo.httpTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/2/13 上午 11:18
 * @since JDK1.8
 */
public class HttpClientUtil2 {
    static Logger logger = LoggerFactory.getLogger(HttpClientUtil2.class);
    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String arg[]) throws Exception {
//        Map map = new HashMap();
//        map.put("str", "hah");
//        map.put("file", new File("G:\\test\\花.jpeg"));
//        String s = mapper.writeValueAsString(map);
//
//        // 把文件转换成流对象FileBody
//        FileBody fileBody = new FileBody(new File("G:\\test\\花.jpeg"));
//        HttpEntity reqEntity = MultipartEntityBuilder.create()
//                .addPart("file", fileBody)
//                .addTextBody("str", "hah")
//                .build();

//        System.out.println(doPost("http://localhost:8080/test/jsonAndFile", reqEntity));


        String url = "http://localhost:8080/test/jsonAndFile";
        String filePath = "G:\\test\\花.jpeg";

        RestTemplate rest = new RestTemplate();
        FileSystemResource resource = new FileSystemResource(new File(filePath));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("file", resource);
        param.add("str", "test.txt");

        String string = rest.postForObject(url, param, String.class);
        System.out.println(string);

    }


    /**
     * post请求
     */
    public static String doPost(String url, HttpEntity reqEntity) throws Exception {
        HttpClient client = null;
        HttpPost request = null;
        client = HttpClientBuilder.create().build();
        request = new HttpPost(url);

        request.setEntity(reqEntity);
        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            logger.info("请求成功" + response.toString());
            String strResult = EntityUtils.toString(response.getEntity(), "utf-8");
            return strResult;
        } else {
            logger.info("响应信息 response header: " + response.getAllHeaders());
            logger.info("响应码 response HttpStatus: {}", response.getStatusLine().getStatusCode());

            throw new Exception("cd");
        }

    }
}
