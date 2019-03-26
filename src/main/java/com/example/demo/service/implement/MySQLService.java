package com.example.demo.service.implement;

import com.example.demo.dao.userDao;
import com.example.demo.domain.T_Members;
import com.example.demo.domain.t_goods;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySQLService implements userService {
    @Autowired
    userDao dao;

    @Override//传商品信息
    public Boolean form_basic(t_goods Good){ return dao.form_basic(Good);}

    @Override     //注册信息
    public  Boolean registerindex(T_Members Member){ return dao.registerindex(Member);}

    @Override
    public t_goods getT_goods(){
        return dao.getT_goods();
    }
}

