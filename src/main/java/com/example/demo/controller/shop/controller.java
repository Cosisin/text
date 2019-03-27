package com.example.demo.controller.shop;

import com.example.demo.domain.T_Members;
import com.example.demo.domain.t_goods;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class controller {
    @Autowired
    userService userservice;

    /**
     *
     * @param Member
     * @return 注册成功 or 注册失败
     */
    @PostMapping("/registerindex")   //用户注册
    public String registerindex(@RequestBody T_Members Member){
        if(userservice.registerindex(Member)) {
            return "注册成功";
        } else
            return "注册失败";
    }

    /**
     *登录   已通
     * @param member U_name & U_password
     * @param session
     * @return 登录成功 || 密码错误 || 账号错误
     */
    @PostMapping("/login")
    public String login(@RequestBody T_Members member,HttpSession session){
        String info = userservice.login(member);
            if (info.equals("登录成功")){
                session.setAttribute("name",member.getName());
                return "登录成功";
            }else
                return info;
    }

    /**
     * 录入商品
     * @param goods  g_id g_name g_brand g_intro g_Area g_price g_date g_place g_weight
     * @return
     */
    @PostMapping("/inputGoods")
    public String inputGoods(@RequestBody t_goods goods){
        if (userservice.inputGoods(goods)) {
            return "录入成功";
        } else {
            return "录入失败";
        }
    }

    @GetMapping("/getGoods")
    public List<t_goods> getGoods(){
      return userservice.getGoods();
    }

    @GetMapping("/getT_goods")
    public t_goods getT_goods(){
        return userservice.getT_goods();
    }
}
