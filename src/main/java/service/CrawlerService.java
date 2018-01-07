package service;

import model.JDModel;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wean on 2018/1/7.
 */
public class CrawlerService {
    public static List<JDModel> getData(HttpClient client, String url) throws IOException {
        List<JDModel> data=new ArrayList<>();


        HttpResponse response= HttpUtil.getRawHtml(client,url);
        int statusCode=response.getStatusLine().getStatusCode();
        if (statusCode==200){

            String html=EntityUtils.toString(response.getEntity(),"UTF-8");
            data=htmlParse(html);
        }
        EntityUtils.consume(response.getEntity());
        return data;
    }
    public static List<JDModel> htmlParse(String html) {
        List<JDModel> data = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements elements = document.select("ul[class=gl-warp clearfix]").select("li[class=gl-item");

        for (Element ele : elements) {
            JDModel jdModel = new JDModel();
            jdModel.setBookId(ele.attr("data-sku"));
            jdModel.setBookName(ele.select("div[class=p-name").select("em").text());
            jdModel.setBookPrice(ele.select("div[class=p-price]").select("strong").select("i").text());
            String bookImage = ele.select("div[class=p-img]").select("img").attr("src");
            if ("".equals(bookImage)) {
                bookImage = ele.select("div[class=p-img]").select("img").attr("data-lazy-img");
            }
            jdModel.setBookImage(bookImage);
            data.add(jdModel);
        }
        return data;
    }





}
