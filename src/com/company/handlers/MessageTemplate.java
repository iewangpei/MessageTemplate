package com.company.handlers;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Message")
@Controller
public class MessageTemplate {
    @RequestMapping("/upload")
    public String doUpload(@RequestParam("fileName") MultipartFile file, HttpSession session, Map<String,Object> map) throws IllegalStateException, IOException{
        if(!file.isEmpty()){
            //创建文件路径
            String path = session.getServletContext().getRealPath("/files");
            //获取文件名
            String fileName = file.getOriginalFilename();
            //限制上传类型
            System.out.println(path);
            System.out.println(fileName);
//            String message = new String(file.getBytes());
            InputStream is = file.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String s = "";
            List<String> list = new ArrayList<String>();
            while((s = br.readLine()) != null){
                s = replaceAll(s);   
                list.add(s);
            }      


            map.put("message",list);
//            if(fileName.endsWith(".txt")){
//                File newFile = new File(path,fileName);
//                //上传
//                file.transferTo(newFile);
//            }else{
//                return "fail";
//            }
            
        }                
        return "Message";
    }

    private String replaceAll(String s) {
        s = s.replaceAll("\\[|\\]", "");
        s = s.replaceAll(":T:", "<input type=\"text\" name=\"username\">");
        System.out.println(s);
        return s ;
    }

}
