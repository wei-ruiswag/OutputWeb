package com.outputweb.controller.mall;

import com.alibaba.fastjson.JSON;
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
        request.setAttribute("path", "personal");
        return "personal";
    }
}
