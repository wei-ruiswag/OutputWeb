package com.outputweb.controller.admin;


import com.alibaba.fastjson.JSON;
import com.outputweb.controller.vo.GoodsVO;
import com.outputweb.controller.vo.NewsVO;
import com.outputweb.utils.HttpRequest;
import com.outputweb.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminNewsController {
    @GetMapping("/news")
    public String newsPage(HttpServletRequest request) {
        request.setAttribute("path", "news");
        return "admin/news";
    }

    @GetMapping("/news/edit")
    public String NewsPage(HttpServletRequest request)  {

        request.setAttribute("path", "news-edit");
        return "admin/news-edit";
    }

    @GetMapping("/news/edit/{newsId}")
    public String edit(HttpServletRequest request, @PathVariable("newsId") Long newsId) throws Exception{
        HttpRequest handle = new HttpRequest();
        Result res= JSON.parseObject(handle.get("http://175.178.153.116:8080/news/detail/"+newsId), Result.class);
        //GoodsDetailVO goodsDetailVO = JSON.parseObject(handle.get("http://175.178.153.116:8080/goods/detail/10005"), GoodsDetailVO.class);
        String js=JSON.toJSONString(res.getData());
        System.out.print(res.getData());
        NewsVO newsVO = JSON.parseObject(js,NewsVO.class);

        request.setAttribute("news", newsVO);
        request.setAttribute("path", "news-edit");
        return "admin/news-edit";
    }
}
