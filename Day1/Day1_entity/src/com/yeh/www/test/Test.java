package com.yeh.www.test;

import com.yeh.www.dao.UserDao;
import com.yeh.www.dao.impl.UserDaoImpl;
import com.yeh.www.entity.User;

import java.util.List;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/19 - 12 - 19 - 13:16
 * @Description: com.yeh.www.test
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        List<User> alluser = userDao.getAllUser();
        for(User user:alluser){
            System.out.println(user);
        }
    }
}
