package com.alv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/18 11:58
 * @description：
 */
@Controller
public class TestController {
    @RequestMapping("/success")
    public String success(){
        int i = 10/0;
        return "success";
    }
}
