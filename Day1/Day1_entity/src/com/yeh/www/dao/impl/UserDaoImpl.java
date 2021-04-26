package com.yeh.www.dao.impl;

import com.yeh.www.dao.UserDao;
import com.yeh.www.entity.User;
import com.yeh.www.utils.DBUtils;
import com.yeh.www.utils.DruidUtils;

import java.awt.desktop.UserSessionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/19 - 12 - 19 - 12:34
 * @Description: com.yeh.www.dao.impl
 * @version: 1.0
 */
public class UserDaoImpl<Preparedstatement> implements UserDao {
    private Connection connection = null;
    private Preparedstatement preparedstatement = null;
    private ResultSet resultSet = null;
    private Statement statement;
    private Object Collection;


    @Override
    public List<User> getAllUser() {
       // connection =DBUtils.getConnection();
        connection = DruidUtils.getConnection();
        String sql = "select *from user";
        User user = null;
        List<User> users = new ArrayList<User>();
        try {
            preparedstatement = (Preparedstatement) connection.prepareStatement(sql);
            resultSet = ((PreparedStatement) preparedstatement).executeQuery();
            while(resultSet.next()){
               // user = new User();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                user = new User(id,username,password,phone);
                //每拿到一个个实体，添加到集合里
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.closeAll(resultSet, statement, (Connection) Collection);
           // DBUtils.closeAll(resultSet, statement, (Connection) Collection);
        }
        return null;
    }
    @Override
    public User getUserByNo(int userNo) {
        return null;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }
}
