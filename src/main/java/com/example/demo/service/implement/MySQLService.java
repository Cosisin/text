package com.example.demo.service.implement;

import com.example.demo.dao.userDao;
import com.example.demo.domain.T_Members;
import com.example.demo.domain.t_goods;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySQLService implements userService {
    @Autowired
    userDao dao;


    @Override     //注册信息
    public  Boolean registerindex(T_Members Member){ return dao.registerindex(Member);}

    @Override
    public t_goods getT_goods(){
        return dao.getT_goods();
    }

    @Override
    public String login(T_Members member){return dao.login(member);}

    @Override
    public Boolean inputGoods(t_goods goods){return dao.inputGoods(goods);}

    @Override
    public List<t_goods> getGoods(){return dao.getGoods();}
}

