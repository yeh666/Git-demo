package com.yeh.www.dao;

import com.yeh.www.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/19 - 12 - 19 - 12:25
 * @Description: com.yeh.www.dao
 * @version: 1.0
 */
/*
数据访问层接口，定义了访问数据库的方法
/
 */
public interface UserDao {
    //查询所有
    List<User>  getAllUser() ;
    //查询单个
    User getUserByNo(int userNo);
    //增加
    int add(User user);
    //修改
    int update(User user);
    //删除
    int delete(User user);
}
