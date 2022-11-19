package com.alv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/18 16:20
 * @description：
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        int i = 10/0;
        return "index";
    }

}
