package com.zuoye.service;

import com.zuoye.pojo.User;

import java.util.Map;

public interface UserService {
    public User login(Map<String, String> map);

    public void regist(User user);

}
