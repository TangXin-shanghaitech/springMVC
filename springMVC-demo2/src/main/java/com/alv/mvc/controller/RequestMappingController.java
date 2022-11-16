package com.alv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/16 11:36
 * @description：
 */
@Controller
//@RequestMapping("/hello")
//意义就是 用户的list 订单的list 这样就很方便 多一层目录分类
public class RequestMappingController {
//    @RequestMapping("/")  两个控制器方法一样的maping会报错！  必须保持唯一
//    public String index(){
//        return "index";
//    }
        @RequestMapping(value={"/testRequestMapping", "/test"},method = {RequestMethod.POST})
    public String index(){
        return "success";
    }


    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }


    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }



//    @RequestMapping(value = "/testParamsAndHeaders",
//            params = {"username=admin"})
    @RequestMapping(value = "/testParamsAndHeaders",
            headers = {"Host=localhost:8081"}
           )

    public String testParamsAndHeaders(){
        return "success";
    }


    @GetMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id, @PathVariable("username")String username){
        System.out.println("id=" + id);
        System.out.println("username = "+ username);
        return "success";
    }




}
