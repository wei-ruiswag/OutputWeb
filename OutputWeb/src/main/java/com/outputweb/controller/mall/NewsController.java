package com.outputweb.controller.mall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
    //动态列表
    @GetMapping({"/newList", "newList.html"})
    public String newsPage() {

        return "newList";
    }

    //动态详情
    @GetMapping({"/newDetail", "newdetail.html"})
    public String newPage() {
        return "newDetail";
    }
}
