package com.xhh.system.tj.matchoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/matchOA/edit")
public class EditController {

    @RequestMapping("/score.html")
    private String editScore(String id){

        return "editScore";//编辑得分页
    }
}
