package com.example.demo.service;

import com.example.demo.domain.T_Members;
import com.example.demo.domain.t_goods;

import java.util.List;

public interface userService {


    Boolean registerindex(T_Members Member);   //用户注册

    t_goods getT_goods();

    String login(T_Members member);

    Boolean inputGoods(t_goods goods);

    List<t_goods> getGoods();
}
