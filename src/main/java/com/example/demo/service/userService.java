package com.example.demo.service;

import com.example.demo.domain.T_Members;
import com.example.demo.domain.t_goods;

public interface userService {

    Boolean form_basic(t_goods Good);   //商品信息

    Boolean registerindex(T_Members Member);   //用户注册

    t_goods getT_goods();
}
