
package com.outputweb.controller.admin;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/admin")
public class AdminController {


//    @GetMapping({"/test"})
//    public String test() {
//        return "admin/test";
//    }


    @GetMapping({"", "/", "/index", "/index.html"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        return "admin/index";
    }


//    @GetMapping("/profile")
//    public String profile(HttpServletRequest request) {
//
//        request.setAttribute("path", "profile");
////        request.setAttribute("loginUserName", adminUser.getLoginUserName());
////        request.setAttribute("nickName", adminUser.getNickName());
//        return "admin/profile";
//    }


//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        request.getSession().removeAttribute("loginUserId");
//        request.getSession().removeAttribute("loginUser");
//        request.getSession().removeAttribute("errorMsg");
//        return "admin/login";
//    }
}
