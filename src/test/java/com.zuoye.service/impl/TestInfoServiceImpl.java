package com.zuoye.service.impl;
import  com.zuoye.mapper.InfoMapper;
import com.zuoye.pojo.Info;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.Calendar;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestInfoServiceImpl {
    @Autowired
    InfoServiceImpl infoService;
    @Autowired
     InfoMapper infoMapper;
    Info info=new Info(3,"java",new Date(2018,12,15),"今天学习java");
    @Test
    public void updateById() {
        // TODO Auto-generated method stub
        infoService.infoMapper.updateById(info);
        System.out.println(info);

    }
    @Test
    public void delete(){
        infoService.infoMapper.delete(30);
    }
}
