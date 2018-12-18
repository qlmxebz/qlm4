package com.zuoye.mapper;
import java.util.Map;

import com.zuoye.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    public User login(Map<String, String> map);

    public void addUser(@Param("telephone")String telephone, @Param("password")String password);
}
