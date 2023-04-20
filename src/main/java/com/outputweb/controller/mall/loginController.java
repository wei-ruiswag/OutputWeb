package com.outputweb.controller.mall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {
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

}


