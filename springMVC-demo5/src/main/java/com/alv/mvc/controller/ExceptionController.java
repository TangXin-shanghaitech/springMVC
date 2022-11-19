package com.alv.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/18 15:00
 * @description：
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String success(Exception exception, Model model){
        model.addAttribute("ex",exception);
        return "error";
    }
}
