package com.xhh.system.tj.matchoa.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xhh.system.tj.matchoa.dto.LoginDTO;
import com.xhh.system.tj.matchoa.dto.ResultDTO;
import com.xhh.system.tj.matchoa.model.User;
import com.xhh.system.tj.matchoa.model.UserExample;
import com.xhh.system.tj.matchoa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/matchOA/welcome")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 访问登录页
     */
    @RequestMapping("/login.html")
    public String loginPage(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public Object doLogin(LoginDTO loginDTO){

        String userName=loginDTO.getLoginName();
        String password=loginDTO.getLoginPwd();



        ResultDTO resultDTO =loginService.selectUserInfo(userName,password);//查询用户名是否存在

        if(resultDTO.getCode().equals(200)) {
            StpUtil.setLoginId(userName);
            String tokenValue=StpUtil.getTokenValue();

            User user=new User();
            user.setLoginName(userName);
            user.setToken(tokenValue);
            loginService.createOrUpdateUser(user);
            return ResultDTO.okOf();
        }else {
            return resultDTO;
        }

    }

}
