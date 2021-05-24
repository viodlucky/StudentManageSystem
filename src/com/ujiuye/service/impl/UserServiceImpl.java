package com.ujiuye.service.impl;

import com.ujiuye.dao.impl.UserDaoImpl;
import com.ujiuye.entity.User;
import com.ujiuye.service.UserService;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDaoImpl = new UserDaoImpl();

    public boolean login(String username, String password){
        User user = userDaoImpl.login(username,password);
        boolean res = true;
        if (user == null){
            res = false;
        }
        return res;
    }

    public boolean signUp(String username, String password){
        int rows = userDaoImpl.signUp(username,password);
        boolean res = true;
        if (rows == 0){
            res = false;
        }
        return res;
    }
}
