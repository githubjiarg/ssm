package com.huawei.demo.interceptor;

import com.huawei.demo.Constant;
import com.huawei.demo.entity.UserBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  登陆拦截配置
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute(Constant.SESSION_NAME);
        if ( null != userBean) {
            return true;
        }
        System.out.println("----------  LoginInterceptor ------------");
        // 转发至登陆页面
        request.getRequestDispatcher("/login.html").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
