package com.outputweb.controller.mall;

import com.alibaba.fastjson.JSON;
import com.outputweb.common.Constants;
import com.outputweb.controller.vo.GoodsDetailVO;
import com.outputweb.utils.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller

public class PersonalController {

    @GetMapping("/personal")
    public String personalPage(HttpServletRequest request,
                               HttpSession httpSession) {
//        httpSession=request.getSession();
//        httpSession.setAttribute("path", "personal");
//        request.getSession().setAttribute("path", "personal");
        request.setAttribute("path", "personal");
        return "personal";
    }
    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute(Constants.MALL_USER_SESSION_KEY);
        return "login";
    }
}
