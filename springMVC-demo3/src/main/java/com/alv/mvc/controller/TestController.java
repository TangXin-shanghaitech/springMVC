package com.alv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/16 17:00
 * @description：
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }



}
