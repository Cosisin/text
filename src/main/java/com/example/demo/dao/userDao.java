package com.example.demo.dao;

import com.example.demo.domain.T_Members;
import com.example.demo.domain.t_goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class userDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    private static final RowMapper<t_goods> Goods = new RowMapper<t_goods>() {
        @Override
        public t_goods mapRow(ResultSet resultSet, int i) throws SQLException {
            t_goods goods= new t_goods();
            goods.setG_id(resultSet.getString("Gid"));
            goods.setG_name(resultSet.getString("Gname"));
            goods.setG_Area(resultSet.getString("GArea"));
            goods.setG_brand(resultSet.getString("Gbrand"));
            goods.setG_date(resultSet.getString("Gdate"));
            goods.setG_intro(resultSet.getString("Gintro"));
            goods.setG_place(resultSet.getString("Gplace"));
            goods.setG_price(resultSet.getInt("Gprice"));
            goods.setG_weight(resultSet.getInt("Gweight"));
            return goods;
        }
    };

    private static final RowMapper<T_Members> Members = new RowMapper<T_Members>() {
        @Override
        public T_Members mapRow(ResultSet resultSet, int i) throws SQLException {
            T_Members Mem = new T_Members();
            Mem.setU_name(resultSet.getString("Uname"));
            Mem.setU_password(resultSet.getString("Upassword"));
            Mem.setU_address(resultSet.getString("Uaddress"));
            Mem.setU_birthday(resultSet.getDate("Ubirthday"));
            Mem.setU_email(resultSet.getString("Uemail"));
            Mem.setU_gender(resultSet.getString("Ugender"));
            Mem.setU_grade(resultSet.getString("Ugrade"));
            Mem.setU_major(resultSet.getString("Umajor"));
            Mem.setU_tel(resultSet.getString("Utel"));
            return Mem;
        }
    };

    public Boolean form_basic (t_goods Good){   //商品信息
        try{
            jdbcTemplate.update("insert into t_goods (Gid,Gname,Gbrand,Gprice,Gdate,Gplace,Gweight,Gintro,GArea) values (?,?,?,?,?,?,?,?,?)",Good.getG_id(),Good.getG_name(),Good.getG_brand(),Good.getG_price(),Good.getG_date(),Good.getG_place(),Good.getG_weight(),Good.getG_intro(),Good.getG_Area());
            return true;
        }catch (Exception a){
            return false;

        }
    }

    public  Boolean registerindex (T_Members Member){  //用户注册信息
        try{
            jdbcTemplate.update("insert into T_Members(Uname,Upassword,Ugender,Ubirthday,Uemail,Utel,Uaddress,Ugrade,Umajor) values (?,?,?,?,?,?,?,?,?)",Member.getU_name(),Member.getU_password(),Member.getU_gender(),Member.getU_birthday(),Member.getU_email(),Member.getU_tel(),Member.getU_address(),Member.getU_grade(),Member.getU_major());
            return  true;
        }catch (Exception a){
            return false;
        }
    }

    public t_goods getT_goods(){
        List<t_goods> all=jdbcTemplate.query("select * from t_goods ",Goods);
        t_goods info= all.get(0);
        return info;
    }


}