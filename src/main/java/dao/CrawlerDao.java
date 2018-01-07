package dao;

import model.JDModel;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtil;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wean on 2018/1/7.
 */
public class CrawlerDao {
    static DataSource ds = DataSourceUtil.getDataSource("jdbc:mysql://localhost:3306/test");
    static QueryRunner qr = new QueryRunner(ds);

    public static void executeInsert(List<JDModel> data) {
        Object[][] params = new Object[data.size()][4];
        try {
            for (int i = 0; i < params.length; i++) {
                params[i][0] = data.get(i).getBookId();
                params[i][1] = data.get(i).getBookName();
                params[i][2] = data.get(i).getBookPrice();
                params[i][3] = data.get(i).getBookImage();

            }
            qr.batch("insert into t_book(bookId,bookName,bookPrice,bookImage)" + "values(?,?,?,?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
