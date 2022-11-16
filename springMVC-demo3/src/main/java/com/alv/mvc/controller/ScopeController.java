package com.alv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/16 17:08
 * @description：
 */
@Controller
public class ScopeController {

//    使用 servletAPI 向Request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope", "hello,testRequestScope");

        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
//        处理模型数据  即 向请求request共享数据
        modelAndView.addObject("testRequestScope","hello,testModelAndView");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,model");
        return "success";


    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope","hello,map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
//        modelMap.addAttribute("testRequestScope","hello,modelMap");
        modelMap.put("testRequestScope","hello,modelMap ppppp");
        return "success";
    }






}
