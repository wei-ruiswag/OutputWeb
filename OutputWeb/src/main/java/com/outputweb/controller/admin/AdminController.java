
package com.outputweb.controller.admin;



import com.outputweb.common.Constants;
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


    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.MALL_USER_SESSION_KEY);
        return "admin/login";
    }
}
