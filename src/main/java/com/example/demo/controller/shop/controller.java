package com.example.demo.controller.shop;

import com.example.demo.domain.T_Members;
import com.example.demo.domain.t_goods;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    userService userservice;

    @PostMapping("/form_basic")  //商品上传
    public String form_basic(@RequestBody t_goods Good){
        if(userservice.form_basic(Good)){
            return "上传成功";
        }else
        return "上传失败";
    }

    @PostMapping("/registerindex")   //用户注册
    public String registerindex(@RequestBody T_Members Member){
        if(userservice.registerindex(Member)) {
            return "注册成功";
        } else
            return "注册失败";
    }


    @GetMapping("/getT_goods")
    public t_goods getT_goods(){
        return userservice.getT_goods();
    }

}
