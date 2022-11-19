package com.alv.mvc.controller;

import com.alv.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/17 16:32
 * @description：
 */
@Controller
public class HttpController {
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:"+requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("requestHeader:"+requestEntity.getHeaders());
        System.out.println("requestBody:"+requestEntity.getBody());
        return "success";
    }


    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().println("response");
    }


//    @RequestMapping("/testResponseBody")
//    public String testResponseBody() throws IOException {
//        return "success";
//    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() throws IOException {
        return "success";
    }


    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(HttpServletResponse response) throws IOException {
        return new User("1","tx","13");
    }


    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password)  {
        System.out.println("username= " + username);
        return "hello axios";
    }



}
