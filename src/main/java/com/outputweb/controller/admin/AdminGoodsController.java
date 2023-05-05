package com.outputweb.controller.admin;

import com.alibaba.fastjson.JSON;
import com.outputweb.controller.vo.GoodsVO;
import com.outputweb.utils.HttpRequest;
import com.outputweb.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminGoodsController {

    @GetMapping("/goods")
    public String goodsPage(HttpServletRequest request) {
        request.setAttribute("path", "goods");
        return "admin/goods";
    }

    @GetMapping("/goods/edit")
    public String GoodsPage(HttpServletRequest request)  {

        request.setAttribute("path", "goods-edit");
        return "admin/goods-edit";
    }

    @GetMapping("/goods/edit/{goodsId}")
    public String edit(HttpServletRequest request, @PathVariable("goodsId") Long goodsId) throws Exception{
        HttpRequest handle = new HttpRequest();
        Result res= JSON.parseObject(handle.get("http://175.178.153.116:8080/admin/goods/info/"+goodsId), Result.class);
        //GoodsDetailVO goodsDetailVO = JSON.parseObject(handle.get("http://175.178.153.116:8080/goods/detail/10005"), GoodsDetailVO.class);
        String js=JSON.toJSONString(res.getData());
        System.out.print(res.getData());
        GoodsVO goodsVO = JSON.parseObject(js,GoodsVO.class);

        request.setAttribute("goods", goodsVO);
        request.setAttribute("path", "goods-edit");
        return "admin/goods-edit";
    }
}
