package com.ujiuye.service;

public interface UserService {
    public boolean login(String username, String password);

    public boolean signUp(String username, String password);

}
