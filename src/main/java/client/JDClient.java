package client;

import dao.CrawlerDao;
import model.JDModel;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import service.CrawlerService;

import java.io.IOException;
import java.util.List;

/**
 * Created by Wean on 2018/1/7.
 */
public class JDClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client= HttpClientBuilder.create().build();
        String url="http://search.jd.com/Search?keyword=Python&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb";
        List<JDModel> data= CrawlerService.getData(client,url);
        System.out.println("data" + data.size());
        for (JDModel item:
             data) {
            System.out.println(item.getBookId()+","+item.getBookName());
        }
        CrawlerDao.executeInsert(data);
    }
}
