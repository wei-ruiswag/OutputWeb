package com.outputweb.controller.mall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //主页
    @GetMapping({"/index", "index.html"})
    public String getPage() {
        return "index";
    }
    @GetMapping({"/header", "header.html"})
    public String getHeaderPage() {
        return "header";
    }
    @GetMapping({"/footer", "footer.html"})
    public String getFooterPage() {
        return "footer";
    }

}
