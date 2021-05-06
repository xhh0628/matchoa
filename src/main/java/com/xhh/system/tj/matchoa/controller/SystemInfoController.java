package com.xhh.system.tj.matchoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/matchOA/systemInfo")
public class SystemInfoController {

    @RequestMapping("/introduce.html")
    private String systemVer(){

        return "introduce";
    }
}
