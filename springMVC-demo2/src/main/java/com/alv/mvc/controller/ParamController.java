package com.alv.mvc.controller;

import com.alv.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/16 14:12
 * @description：
 */
@Controller
public class ParamController {

    @GetMapping("/testServletAPI")
//    自动赋值传递这么牛逼
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("pwd"));

        return "success";
    }

    @RequestMapping("/testParam")
//    更加牛逼的自动赋值  byname?上面bytype?
//    public String testParam(String username ,String pwd,String hobby){
    public String testParam(@RequestParam(value = "user_name" ,required = false,defaultValue = "null") String username , String pwd, String[] hobby,
                            @RequestHeader(value = "Host")String host,
                            @CookieValue(value = "JSESSIONID",required = false) String JSESSIONID)


    {
        System.out.println(username);
        System.out.println(pwd);
        System.out.println(hobby);
        System.out.println(JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
//    你想 如果下面这样可以一个个自动赋值  那不如一口气都给一个bean
//    public String testParam(@RequestParam(value = "user_name" ,required = false,defaultValue = "null") String username , String pwd
//    public String testBean(User user1  User user2){  只要满足 一样获取参数 只不过没有意义
    public String testBean(User user){
        System.out.println(user);

        return "success";
    }

}
