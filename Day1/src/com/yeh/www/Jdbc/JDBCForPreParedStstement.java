package com.yeh.www.Jdbc;

import javax.print.attribute.standard.JobOriginatingUserName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/18 - 12 - 18 - 20:45
 * @Description: com.yeh.www.Jdbc
 * @version: 1.0
 */
public class JDBCForPreParedStstement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String usename =sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql2?useSSL=false&serverTimezone=UTC", "root", "1234");

            //获得PreparedStatement ?==占位符
            String sql = "select username,password from user where username = ? and password = ?";
            //预编译SQL语句，该语句占位符展示的是 没有具体的值
            preparedStatement = connection.prepareStatement(sql);
            //为每一个占位符赋予一个值
           // preparedStatement.setObject(1username);
            preparedStatement.setObject(1,usename);
            preparedStatement.setObject(2,password);
            resultSet = preparedStatement.executeQuery();
            //System.out.println(resultSet.next());
            if(resultSet.next()){
                System.out.println("登录成功！");
            }else{
                System.out.println("登录失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
