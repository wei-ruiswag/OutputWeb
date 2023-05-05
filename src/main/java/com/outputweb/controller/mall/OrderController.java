package com.outputweb.controller.mall;

import com.alibaba.fastjson.JSON;
import com.outputweb.controller.vo.GoodsDetailVO;
import com.outputweb.controller.vo.OrderDetailVO;
import com.outputweb.controller.vo.ShoppingCartItemVO;
import com.outputweb.utils.HttpRequest;
import com.outputweb.utils.PageResult;
import com.outputweb.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @GetMapping("/orders/{orderNo}")
    public String orderDetailPage(HttpServletRequest request, @PathVariable("orderNo") String orderNo, @RequestParam("userId") Long userId, HttpSession httpSession) throws Exception{
//        System.out.println(orderNo);
        HttpRequest handle = new HttpRequest();
        Result res= JSON.parseObject(handle.get("http://175.178.153.116:8080/orders/"+orderNo+"?userId="+userId.toString()), Result.class);
        String js=JSON.toJSONString(res.getData());
        OrderDetailVO orderDetailVO = JSON.parseObject(js, OrderDetailVO.class);
//        System.out.println(orderDetailVO.getOrderNo());
        request.setAttribute("orderDetailVO", orderDetailVO);
        return "order-detail";
    }



    @GetMapping("/ordersList")
    public String orderListPage(HttpServletRequest request, HttpSession httpSession,@RequestParam("page") int page) throws Exception {
        HttpRequest handle = new HttpRequest();
        Result res = JSON.parseObject(handle.get("http://175.178.153.116:8080/ordersList?page="+page), Result.class);
//        PageResult orderPageResult = JSON.parseObject(handle.get("http://175.178.153.116:8080/ordersList"), PageResult.class);

        String js=JSON.toJSONString(res.getData());
        PageResult orderPageResult = JSON.parseObject(js, PageResult.class);
//        System.out.println(res.getData());
//        System.out.println(orderPageResult.getTotalPage());

        request.setAttribute("orderPageResult",orderPageResult);
        request.setAttribute("path", "ordersList");
        return "my-orders";
    }


    @GetMapping("/selectPayType")
    public String selectPayType(HttpServletRequest request, @RequestParam("orderNo") String orderNo, @RequestParam("userId") Long userId,HttpSession httpSession) throws Exception{
        System.out.println(userId);
        HttpRequest handle = new HttpRequest();
        Result res= JSON.parseObject(handle.get("http://175.178.153.116:8080/selectPayType?orderNo="+orderNo+"&userId="+userId.toString()), Result.class);
        System.out.println(res.getData());
        String js=JSON.toJSONString(res.getData());
        System.out.println(js);
//        OrderDetailVO orderDetailVO = JSON.parseObject(js, OrderDetailVO.class);
        request.setAttribute("orderNo", orderNo);
        request.setAttribute("path","selectPayType");
        request.setAttribute("totalPrice", res.getData());
        return "pay-select";
    }

    @GetMapping("/payPage")
    public String payOrder(HttpServletRequest request, @RequestParam("orderNo") String orderNo, HttpSession httpSession,@RequestParam("userId") Long userId, @RequestParam("payType") int payType) throws Exception {

        HttpRequest handle = new HttpRequest();
        Result res= JSON.parseObject(handle.get("http://175.178.153.116:8080/selectPayType?orderNo="+orderNo+"&userId="+userId.toString()), Result.class);

        request.setAttribute("orderNo", orderNo);
        request.setAttribute("totalPrice", res.getData());
        request.setAttribute("path","payPage");
        if (payType == 1) {
            return "alipay";
        } else {
            return "wxpay";
        }
    }
}
