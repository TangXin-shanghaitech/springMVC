package com.alv.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/17 18:26
 * @description：
 */
@Controller
public class FileUpAndDownController {


    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testDown(HttpSession session) throws IOException
    {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/img.png");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字 key是固定的 attachment 表示以附件
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
//        System.out.println(photo.getName());
//        System.out.println(photo.getOriginalFilename());
//        获取上传的文件名
        String originalFilename = photo.getOriginalFilename();
//        获取文件的后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")); // 1.1.1.png
//        将uuid作为文件名
        String uuid = UUID.randomUUID().toString();
//        将uuid拼接后缀名作为文件名
        originalFilename = uuid + substring;



        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if (!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + originalFilename;
        System.out.println(finalPath);
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
