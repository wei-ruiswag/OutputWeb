package com.outputweb.interceptor;

import com.outputweb.common.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台管理系统身份验证拦截器
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        String requestServletPath = request.getServletPath();
//        if (requestServletPath.startsWith("/admin") && request.getSession().getAttribute(Constants.MALL_USER_SESSION_KEY) != "1") {
//            request.getSession().setAttribute("errorMsg", "您没有权限！");
//            response.sendRedirect(request.getContextPath() + "/login");
//            return false;
//        } else {
//            request.getSession().removeAttribute("errorMsg");
//            return true;
//        }
        System.out.println("interceptor userId:" + request.getSession().getAttribute(Constants.MALL_USER_SESSION_KEY));
        if (request.getSession().getAttribute(Constants.MALL_USER_SESSION_KEY).toString().equals("1")) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            request.getSession().setAttribute("errorMsg", "您没有权限！");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
