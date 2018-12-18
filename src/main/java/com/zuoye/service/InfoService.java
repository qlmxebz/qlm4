package com.zuoye.service;

import com.zuoye.pojo.Info;

import java.util.List;

public interface InfoService {
    public void delete(Integer id);
    public List<Info> queryAll();
    public Info queryById(Integer id);
    public void updateById(Info info);
}
