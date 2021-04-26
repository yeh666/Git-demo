package com.yeh.www.Jdbc;

import com.mysql.cj.protocol.x.CompressionSplittedOutputStream;
import com.sun.jdi.PathSearchingVirtualMachine;

import java.sql.*;
import java.util.zip.GZIPInputStream;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/18 - 12 - 18 - 13:07
 * @Description: com.yeh.www.Jdbc
 * @version: 1.0
 */
public class JDBCForDML {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql2?useSSL=false&serverTimezone=UTC", "root", "1234");
            statement = connection.createStatement();
           // String sql = "truncate table test ";
            String sql = "insert into test(id,name)values (15,'张三2')";
            int result = statement.executeUpdate(sql);
            //execuateUpdate适用于执行insert,update,delete
            //返回受影响的行数，从而得知操作是否成功
            if(result>0){
            System.out.println("执行完毕");
            }else{
                System.out.println("执行失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}