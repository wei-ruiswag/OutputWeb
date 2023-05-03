package com.outputweb.controller.mall;

import com.alibaba.fastjson.JSON;
import com.outputweb.controller.vo.OrderDetailVO;
import com.outputweb.controller.vo.ShoppingCartItemVO;
import com.outputweb.utils.HttpRequest;
import com.outputweb.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @GetMapping("/orders/{orderNo}")
    public String orderDetailPage(HttpServletRequest request, @PathVariable("orderNo") String orderNo, HttpSession httpSession) throws Exception{

        HttpRequest handle = new HttpRequest();
        OrderDetailVO orderDetailVO = JSON.parseObject(handle.get("http://175.178.153.116:8080/orders/"+orderNo), OrderDetailVO.class);
        request.setAttribute("orderDetailVO", orderDetailVO);
        return "order-detail";
    }

    @GetMapping("/ordersList")
    public String orderListPage(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpSession httpSession) {

        request.setAttribute("path", "ordersList");
        return "my-orders";
    }

    @GetMapping("/saveOrder")
    public String saveOrder(HttpSession httpSession) throws Exception{

//        HttpRequest handle = new HttpRequest();
//        Result res = JSON.parseObject(handle.get("http://175.178.153.116:8080/saveCartOrder"), Result.class);
//        System.out.print(res.getMessage());
//        List<ShoppingCartItemVO> myShoppingCartItems = ShoppingCartService.getMyShoppingCartItems(user.getUserId());
//        if (!StringUtils.hasText(user.getAddress().trim())) {
//            //无收货地址
//            NewBeeMallException.fail(ServiceResultEnum.NULL_ADDRESS_ERROR.getResult());
//        }
//        if (CollectionUtils.isEmpty(myShoppingCartItems)) {
//            //购物车中无数据则跳转至错误页
//            NewBeeMallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
//        }
//        //保存订单并返回订单号
//        String saveOrderResult = newBeeMallOrderService.saveOrder(user, myShoppingCartItems);
        //跳转到订单详情页
//        return "redirect:/ordersList/" + saveOrderResult;
        return "redirect:/ordersList/";
    }

    @GetMapping("/selectPayType")
    public String selectPayType(HttpServletRequest request, @RequestParam("orderNo") String orderNo, HttpSession httpSession) throws Exception{


        request.setAttribute("orderNo", orderNo);
        request.setAttribute("path","selectPayType");
//        request.setAttribute("totalPrice", newBeeMallOrder.getTotalPrice());
        return "pay-select";
    }

    @GetMapping("/payPage")
    public String payOrder(HttpServletRequest request, @RequestParam("orderNo") String orderNo, HttpSession httpSession, @RequestParam("payType") int payType) {

        request.setAttribute("orderNo", orderNo);
//        request.setAttribute("totalPrice", newBeeMallOrder.getTotalPrice());
        request.setAttribute("path","payPage");
        if (payType == 1) {
            return "alipay";
        } else {
            return "wxpay";
        }
    }
}
