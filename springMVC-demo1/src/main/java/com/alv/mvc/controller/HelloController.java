package com.alv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/16 9:51
 * @description：
 */
@Controller
//左边的图标表示 这个对象已经交给ioc容器进行管理
public class HelloController {
//    @RequestMapping(value = "/")  只给value赋值的时候可以不写
    @RequestMapping("/")
    public String index(){
        //返回试图名称
        return "index";
    }

    @RequestMapping("/target")
    public String target(){
        return "target";
    }
}
