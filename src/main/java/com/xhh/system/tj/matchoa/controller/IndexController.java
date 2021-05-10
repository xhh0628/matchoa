package com.xhh.system.tj.matchoa.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/matchOA/index")
public class IndexController {

    @RequestMapping(value = "/oaSystem.html")
    public String index(HttpServletRequest request){

        //是否登陆过
        if (StpUtil.isLogin()){
            //进入首页
            return "index";
        }else{
            //进入登录页
            return "login";
        }


    }
}
