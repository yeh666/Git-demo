package com.yeh.www.utils;

import java.sql.*;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/18 - 12 - 18 - 21:44
 * @Description: com.yeh.www.utils
 * @version: 1.0
 */
//重用性
public class DBUtils {
    //定义连接字符串内容
    public static String url = "jdbc:mysql://localhost:3306/mysql2?useSSL=false&serverTimezone=UTC";
    public static String user = "root";
    public static String password = "1234";

    public static Connection connection = null;
    //1.注册驱动
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
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
    public static void closeAll(ResultSet resultSet, Statement statement,Connection connection){
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
