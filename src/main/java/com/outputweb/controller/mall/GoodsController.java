package com.outputweb.controller.mall;

import com.alibaba.fastjson.JSON;
import com.outputweb.controller.vo.GoodsDetailVO;
import com.outputweb.utils.HttpRequest;
import com.outputweb.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class GoodsController {
    @GetMapping({"/goods/detail"})
    public String detailPage(HttpServletRequest request) throws Exception {
        HttpRequest handle = new HttpRequest();
        Result res= JSON.parseObject(handle.get("http://175.178.153.116:8080/goods/detail/10005"), Result.class);
        //GoodsDetailVO goodsDetailVO = JSON.parseObject(handle.get("http://175.178.153.116:8080/goods/detail/10005"), GoodsDetailVO.class);
        String js=JSON.toJSONString(res.getData());
        System.out.print(res.getData());
        GoodsDetailVO goodsDetailVO = JSON.parseObject(js,GoodsDetailVO.class);

        request.setAttribute("goodsDetail", goodsDetailVO);
//        System.out.print(goodsDetailVO);
        return "detail";
    }
}
