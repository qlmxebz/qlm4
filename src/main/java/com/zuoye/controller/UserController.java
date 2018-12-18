package com.zuoye.controller;

import com.zuoye.pojo.User;
import com.zuoye.service.UserService;
import com.zuoye.util.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Lazy
    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login(HttpServletRequest req, Model model, HttpSession httpSession) {
        Redis redis = new Redis();
        if (redis.reRecord(req.getParameter("telephone"))) {
        } else {
            model.addAttribute("message", "请等待120S!");
            return "login";
        }
        MD5Utils md5 = new MD5Utils();
        String password = md5.encode(req.getParameter("password"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("telephone", req.getParameter("telephone"));
        map.put("password", password);
        User user = userService.login(map);
            if (user != null) {// 登录成功进入消息页面
                httpSession.setAttribute("telephone", map.get("telephone"));
                model.addAttribute("message", " ");
                return "redirect:/info/queryAll";
            } else {// 登录失败回到登录页面
                model.addAttribute("message", "用户名或密码输入错误,请重新输入");
                redis.reRecord(req.getParameter("telephone"));

                return "login";
            }
        }


    @RequestMapping("/goRegister")
    public String goRegister() {
        System.out.println("hello--------------------");
        return "register";
    }

    @RequestMapping("/register")
    public String regist(User user) {


        userService.regist(user);
        System.out.println("hello--------------------");
        return "login";

    }


}
