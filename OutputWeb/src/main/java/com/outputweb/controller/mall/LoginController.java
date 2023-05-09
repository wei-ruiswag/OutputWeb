package com.outputweb.controller.mall;

import com.outputweb.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //登陆
    @GetMapping({"/login", "login.html"})
    public String loginPage() {
        return "login";
    }
    //注册
    @GetMapping({"/register", "register.html"})
    public String logonPage() {
        return "register";
    }
    //登出
    @PostMapping({"/state/login"})
    @ResponseBody
    public void setLoginState(@RequestParam("userId") Long userId, HttpSession session){
        System.out.println("setLoginState:useraId" + userId.toString());
        session.setAttribute(Constants.MALL_USER_SESSION_KEY,userId);
    }
}


