package com.huawei.demo.controller;

import com.huawei.demo.Constant;
import com.huawei.demo.entity.UserBean;
import com.huawei.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserControl {

   @Autowired
   UserServiceImpl userService;

   @RequestMapping("/login")
   @ResponseBody
    public Map login(UserBean userBean, HttpServletRequest request){
       Map<String,Object> map = new HashMap<String, Object>();
      HttpSession session = request.getSession();
       System.out.println("____________________login________________________");
       try{
          boolean flag = userService.login(userBean);
          if ( flag ) {
             session.setAttribute(Constant.SESSION_NAME,userBean);
             session.setMaxInactiveInterval(Constant.SESSION_TIME_OUT);
          }
          map.put("code",0);
          map.put("type",flag);
       }catch (Exception e){
          e.printStackTrace();
          map.put("code",1);
          map.put("type",false);
       }
       return map;
   }



}
