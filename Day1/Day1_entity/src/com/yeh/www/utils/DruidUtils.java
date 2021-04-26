package com.yeh.www.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.swing.text.TabableView;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Collection;
import java.util.Properties;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/19 - 12 - 19 - 14:49
 * @Description: com.yeh.www.utils
 * @version: 1.0
 */
//连接池
public class DruidUtils {
    //创建连接池对象
    private static Connection connection;
    private static DruidDataSource dataSource;
    static {
        //创建连接池
        Properties properties = new Properties();
        InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            properties.load(inputStream);
            //通过德鲁伊连接池工厂创建一个连接池，自动解析properties文件里的键值对
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获得一个连接池
    public static DruidDataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection(){
        try {
            connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
