package com.yeh.www.Jdbc;



import com.yeh.www.utils.DBUtils;
import com.yeh.www.utils.DBUtils2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/18 - 12 - 18 - 19:27
 * @Description: com.yeh.www.Jdbc
 * @version: 1.0
 */
public class JDBCForLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username =  sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.next();

        //连接数据库
        Connection connection =null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            connection =DBUtils2.getConnection();
            statement = connection.createStatement();
            String sql = "select username,password from user where username = '"+username+"' and password = '"+password+"'";
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                System.out.println("登录成功！");
            }else{
                System.out.println("登录失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils2.closeAll(resultSet,statement,connection);
        }

    }
}
