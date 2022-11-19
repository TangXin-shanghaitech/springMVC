package com.alv.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/17 10:34
 * @description：
 */
@Controller
public class UserController {
    /**
     * @Author tx
     * @Date 2022/11/17 10:36
     * @Description  使用restfuul 模拟用户资源的增删改查
     * /user            get     查询所有
     * /user/1          get     根据id查询
     * /user            post    添加用户信息
     * /user/1          delete  根据id删除
     * /user            put     更新用户信息
     * @Param
     * @Return
     * @Since version-1.0
     */

//    @RequestMapping("/user") 这里需要知道请求方式了  也可以使用派生注解
//    @GetMapping("/user")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }


    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(){
        System.out.println("查询id用户信息");
        return "success";
    }


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(String username,String pwd){
        System.out.println("添加用户" + username + "密码" +pwd);
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(String username,String pwd){
        System.out.println("修改用户" + username + "密码" +pwd);
        return "success";
    }











}
