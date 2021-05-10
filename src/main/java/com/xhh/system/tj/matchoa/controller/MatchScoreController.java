package com.xhh.system.tj.matchoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/matchOA/matchScore")
public class MatchScoreController {


    @RequestMapping("martialArt.html")
    private String score(){

        return "matchScore";//分页
    }
}
