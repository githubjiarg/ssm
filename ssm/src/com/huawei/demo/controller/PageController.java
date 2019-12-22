package com.huawei.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  页面路由
 */
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     *  主页路由
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
