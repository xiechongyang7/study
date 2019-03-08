package demo;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * @description
 * @since JDK1.8
 * @createTime 2019/1/28 下午 1:56
 * @author xiechongyang
 */
public class dcd {

    public static void main(String[] arg){

            HttpClient client = null;
            HttpGet request = null;
            String strResult = null;
            HttpResponse response = null;
            try {

                client = HttpClientBuilder.create().build();

//发送get请求
                request = new HttpGet("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548664483657&di=a53e7ddc49e905a2bc12247481db72e6&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201602%2F21%2F20160221112538_LeXNy.jpeg");
                response = client.execute(request);

                FileUtils.writeByteArrayToFile(new File("G:\\hh.png"),EntityUtils.toByteArray(response.getEntity()));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (request != null) {
                    request.releaseConnection();
                }
            }
    }
}
