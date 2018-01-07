package utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;

import java.io.IOException;


/**
 * Created by Wean on 2018/1/7.
 */
public class HttpUtil {
    public static HttpResponse getRawHtml(HttpClient client, String url){
        HttpGet httpGet=new HttpGet(url);
        HttpResponse response=new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"ok");
        try {
            response=client.execute(httpGet);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
