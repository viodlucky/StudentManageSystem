package com.ujiuye.dao.impl;

import com.ujiuye.dao.UserDao;
import com.ujiuye.entity.User;
import com.ujiuye.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = JdbcUtil.getQr();

    public User login(String username, String password) {
        User user = null;
        String sql = "select * from user where username = ? && password = ?";
        try {
            user = qr.query(sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int signUp(String username, String password) {
        int rows = 0;
        String sql = "insert into user(username,password) values(?,?)";
        try {
            rows = qr.update(sql, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
