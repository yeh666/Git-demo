package com.yeh.www.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/18 - 12 - 18 - 10:23
 * @Description: com.yeh.www.Jdbc
 * @version: 1.0
 */
public class TextJDBC1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //创建Connection对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql2?useSSL=false&serverTimezone=UTC","root","1234");
        System.out.println(connection.toString());
        //创建执行SQL语句对象，连接创建对象。指定SQL语句执行的数据库
        Statement statement = connection.createStatement();
        //sql语句
        String sql = "create table if not exists test(id int primary key,name varchar(225) not null)charset=utf8;" ;
        //执行DDL  execute()方法
        boolean result =statement.execute(sql);
        //执行DML
        statement.execute("insert into test(id,name)values(11,'张三')");
        System.out.println(result);

        //关闭释放资源
        statement.close();
        connection.close();
    }
    //execute()方法可以执行任何SQL语句，前提是不需要任何结果


}
