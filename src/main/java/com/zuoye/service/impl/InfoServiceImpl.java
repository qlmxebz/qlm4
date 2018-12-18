package com.zuoye.service.impl;

import com.zuoye.mapper.InfoMapper;
import com.zuoye.pojo.Info;
import com.zuoye.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
     InfoMapper infoMapper;
    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        this.infoMapper.delete(id);
    }

    @Override
    public List<Info> queryAll() {
        // TODO Auto-generated method stub
        return this.infoMapper.queryAll();
    }

    @Override
    public Info queryById(Integer id) {
        // TODO Auto-generated method stub
        return this.infoMapper.queryById(id);
    }

    @Override
    public void updateById(Info info) {
        // TODO Auto-generated method stub
        this.infoMapper.updateById(info);
    }

}