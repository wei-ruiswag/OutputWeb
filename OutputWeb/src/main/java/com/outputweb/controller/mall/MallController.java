package com.outputweb.controller.mall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MallController {
    //商品列表
    @GetMapping({"/mall"})
    public String mallPage() {
        return "mall";
    }





}
