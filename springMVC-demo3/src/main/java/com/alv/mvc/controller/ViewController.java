package com.alv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/16 20:26
 * @description：
 */
@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
//        return "/testThymeleafView";  像转发到上面那个请求你就没办法直接转发了 会被加上前缀后缀变成thymeleaf
        return "forward:/testThymeleafView";//会自动解析去掉前面的forward 然后转发到上面去
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
//        return "/testThymeleafView";  像转发到上面那个请求你就没办法直接转发了 会被加上前缀后缀变成thymeleaf
        return "redirect:/testThymeleafView";//会自动解析去掉前面的forward 然后转发到上面去
    }


}
