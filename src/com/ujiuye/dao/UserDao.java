package com.ujiuye.dao;

import com.ujiuye.entity.User;

public interface UserDao {

    public User login(String username,String password);

    public int signUp(String username, String password);
}
