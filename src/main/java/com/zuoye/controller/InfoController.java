package com.zuoye.controller;

import com.zuoye.pojo.Info;
import com.zuoye.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/delete")
    public String delete(Integer id){
        this.infoService.delete(id);
        return "redirect:/info/queryAll";
    }

    @RequestMapping("/queryAll")
    public ModelAndView queryAll(){
        ModelAndView mv = new ModelAndView("infoList");
        List<Info> listInfo=this.infoService.queryAll();
        mv.addObject("listInfo", listInfo);
        return mv;
    }

    @RequestMapping("/updateById")
    public String updateById(@RequestBody Info info) {
        this.infoService.updateById(info);
        return "redirect:/info/queryAll";
    }

    @RequestMapping("/queryById")
    public String queryById(Integer id, Model model) {
        Info info=this.infoService.queryById(id);
        model.addAttribute("info", info);
        return "infoItem";
    }
}