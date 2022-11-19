package com.alv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/17 0:00
 * @description：
 */
@Controller
public class JspController {

    @RequestMapping("/to_success")
    public String to_success( ){
        return "forward:/success";
    }

    @RequestMapping("/success")

    public String success( ){
        System.out.println("中转");
        return "success";
    }

}






