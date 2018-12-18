package com.zuoye.service.impl;

import com.zuoye.controller.MD5Utils;
import com.zuoye.mapper.UserMapper;
import com.zuoye.pojo.User;
import com.zuoye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(Map<String, String> map) {
        // TODO Auto-generated method stub
        return userMapper.login(map);
    }

    @Override
    public void regist(User user) {
        // TODO Auto-generated method stub
        MD5Utils md5=new MD5Utils();

        String password=md5.encode(user.getPassword());

        userMapper.addUser(user.getTelephone(), password);
    }

}
