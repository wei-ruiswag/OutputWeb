package com.outputweb.controller.mall;


import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.outputweb.controller.vo.ShoppingCartItemVO;
import com.outputweb.utils.HttpRequest;
import com.outputweb.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.outputweb.common.Exception;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.List;

@Controller
public class ShoppingCartController {
    @GetMapping("/cart")
    public String cartListPage(HttpServletRequest request, HttpSession httpSession, Model model) throws java.lang.Exception {
//        Long userId = (Long)request.getAttribute("userId");
//        System.out.println(userId);
        HttpRequest handle = new HttpRequest();
        Result res  = JSON.parseObject(handle.get("http://175.178.153.116:8080/cart?userId=1"), Result.class);
        List<ShoppingCartItemVO> myShoppingCartItems = JSONArray.parseArray(JSON.toJSONString(res.getData()),ShoppingCartItemVO.class);
//        System.out.print(res.getData());
//        System.out.print(myShoppingCartItems.stream().mapToInt(ShoppingCartItemVO::getGoodsCount).sum());
        int itemsTotal = 0;
        int priceTotal = 0;
        if (!CollectionUtils.isEmpty(myShoppingCartItems)) {
            //购物项总数
            itemsTotal = myShoppingCartItems.stream().mapToInt(ShoppingCartItemVO::getGoodsCount).sum();
            if (itemsTotal < 1) {
                Exception.fail("购物项不能为空");
            }
            //总价
            for (ShoppingCartItemVO ShoppingCartItemVO : myShoppingCartItems) {
                priceTotal += ShoppingCartItemVO.getGoodsCount() * ShoppingCartItemVO.getSellingPrice();
            }
            if (priceTotal < 1) {
                Exception.fail("购物项价格异常");
            }
        }
        //request.setAttribute("shoppingCartItem", ShoppingCartItemVO);
        System.out.println(itemsTotal);
        System.out.println(priceTotal);
        //model.addAttribute("myShoppingCartItems", myShoppingCartItems);
        request.setAttribute("itemsTotal", itemsTotal);
        request.setAttribute("priceTotal", priceTotal);
        request.setAttribute("myShoppingCartItems", myShoppingCartItems);
        return "cart";
    }

    @GetMapping("/cart/settle")
    public String settlePage(HttpServletRequest request,
                             HttpSession httpSession,@RequestParam("userId") Long userId) throws java.lang.Exception {
        HttpRequest handle = new HttpRequest();
        Result res  = JSON.parseObject(handle.get("http://175.178.153.116:8080/cart?userId="+userId), Result.class);
        System.out.println(userId);
        List<ShoppingCartItemVO> myShoppingCartItems = JSONArray.parseArray(JSON.toJSONString(res.getData()),ShoppingCartItemVO.class);

        int priceTotal=0;
        //Result res = JSON.parseObject(handle.get("http://175.178.153.116:8080/cart/settle"), Result.class);
        if (CollectionUtils.isEmpty(myShoppingCartItems)) {
            //无数据则不跳转至结算页
            return "cart";
        } else {
            //总价
            for (ShoppingCartItemVO ShoppingCartItemVO : myShoppingCartItems) {
                priceTotal += ShoppingCartItemVO.getGoodsCount() * ShoppingCartItemVO.getSellingPrice();
            }
            if (priceTotal < 1) {
                Exception.fail("购物项价格异常");
            }
        }
        request.setAttribute("priceTotal", priceTotal);
        request.setAttribute("myShoppingCartItems", myShoppingCartItems);
        return "order-settle";
//        if(res.getResultCode()==200){
//            return "order-settle";
//        }else{
//            return res.getMessage();
//        }


    }
}
