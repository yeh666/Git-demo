package com.yeh.www.Jdbc;

import com.yeh.www.entity.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/18 - 12 - 18 - 14:39
 * @Description: com.yeh.www.Jdbc
 * @version: 1.0
 */
/*
public class ResultSet {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        java.sql.ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql2?useSSL=false&serverTimezone=UTC", "root", "1234");
            statement =connection.createStatement();
            String sql = "select id,name from test";
            resultSet = statement.executeQuery(sql);
           //遍历
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("id:"+id+"  name:"+name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}*/
public class ResultSet {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        java.sql.ResultSet resultSet = null;
        List<Test> list = new ArrayList<Test>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql2?useSSL=false&serverTimezone=UTC", "root", "1234");
            statement =connection.createStatement();
            String sql = "select id,username,password,phone from user";
            resultSet = statement.executeQuery(sql);
            //遍历
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                //创建实体映射对象
                Test test = new Test();
                //读取到的数据库的零散数据，封装到实体属性里
                test.setId(id);
                test.setUsername(username);
                test.setPassword(password);
                test.setPhone(phone);
                list.add(test);
                System.out.println(test);
                //System.out.println("id:"+id+"  name:"+name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}