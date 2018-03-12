package com.company.handlers;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.company.bean.Message;
import com.company.utils.StringUtil;

@RequestMapping("/Message")
@Controller
public class MessageTemplate {
    private static int id = 1;
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
            InputStream is = file.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String s = "";
            LinkedHashMap<Message,String> messageMap = new LinkedHashMap<Message,String>();
            while((s = br.readLine()) != null){
                AddMessage(messageMap , s);
            }      
            map.put("message",messageMap);
        }                
        return "Message";
    }

    private void AddMessage(LinkedHashMap<Message, String> messageMap, String s) {        
        if(s.contains("]")){
            String [] arr = s.split("]");
            for(String ss : arr){
                String [] msg = ss.split("\\[");
                if(2 == msg.length){
                    Message message = boxing(msg[1]);
                    messageMap.put(message, msg[0]);
                }
            }
        }
        else{
            messageMap.put(new Message(), s);
        }
    }

    private Message boxing(String string) {
        Message message = new Message();
        String [] op = {":T:",":MT:",":D:",":A:",":V:"};
        for(String s : op){
            if(string.contains(s)){
                String [] arr = string.split(s);
                if(2 == arr.length){
                    message.setMessageID(""+id);
                    message.setDefinition(arr[0]);
                    message.setOperator(s);
                    message.setRequired("Y");
                    message.setValidateMessage(arr[1]);
                    id++;
                }
                break;
            }
        }        
        System.out.println(message.toString());
        return message;        
    }

    private String replaceAll(String s) {
//        List<String> list = StringUtil.getSubUtil(s, ":T:(.*?)]"); 
//        if(!list.isEmpty()){
//            s = s.replaceAll(":T:(.*?)]", "<input type=\"text\" name=\"username\" maxlength=\" "+list.get(0)+"\">");
//        }
//        s = s.replaceAll("\\[|\\]", "");
        System.out.println(s);
        return s ;
    }

}
