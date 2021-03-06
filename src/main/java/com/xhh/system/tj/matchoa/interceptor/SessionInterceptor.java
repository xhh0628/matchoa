package com.xhh.system.tj.matchoa.interceptor;

import com.xhh.system.tj.matchoa.mapper.UserMapper;
import com.xhh.system.tj.matchoa.model.User;
import com.xhh.system.tj.matchoa.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //拦截器，程序处理之前
        Cookie[] cookies = request.getCookies();
        if (cookies!=null &&cookies.length!=0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("matchToken")){
                    String token=cookie.getValue();
                    //存session
                    UserExample userExample = new UserExample();
                    userExample.createCriteria()
                            .andTokenEqualTo(token);
                    List<User> users = userMapper.selectByExample(userExample);
                         if (users.size() != 0) {
                         request.getSession().setAttribute("user",users.get(0));

                    }
                    break;
                }

            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
