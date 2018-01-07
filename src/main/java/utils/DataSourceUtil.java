package utils;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * Created by Wean on 2018/1/7.
 */
public class DataSourceUtil {
    public static DataSource getDataSource(String uri){
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("wean124");
        ds.setUrl(uri);
        return ds;
    }
}
