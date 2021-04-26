package com.yeh.www.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/19 - 12 - 19 - 12:20
 * @Description: com.yeh.www.utils
 * @version: 1.0
 */
public class DBUtils {
    //定义连接字符串内容
    private static String url ;
    private static String user;
    private static String password;
    private static String driver;
    private static Connection connection = null;
    static {
        try {
            //通过流读取文件
            // InputStream inputStream = inputStream = new FileInputStream("src\\db.properties");//不用这个 找资源相对目录
            InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            //为各个属性初始化
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            //1.注册驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2.获得连接
    public static  Connection getConnection(){
        try{
            connection = DriverManager.getConnection(url,user,password);
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    //3.释放资源
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
