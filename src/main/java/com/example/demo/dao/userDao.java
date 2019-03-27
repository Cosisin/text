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
            Mem.setName(resultSet.getString("Uname"));
            Mem.setPassword(resultSet.getString("Upassword"));
            Mem.setAddress(resultSet.getString("Uaddress"));
            Mem.setBirthday(resultSet.getDate("Ubirthday"));
            Mem.setEmail(resultSet.getString("Uemail"));
            Mem.setGender(resultSet.getString("Ugender"));
            Mem.setGender(resultSet.getString("Ugrade"));
            Mem.setMajor(resultSet.getString("Umajor"));
            Mem.setTel(resultSet.getString("Utel"));
            return Mem;
        }
    };


    public  Boolean registerindex (T_Members Member){  //用户注册信息
        try{
            jdbcTemplate.update("insert into T_Members(Uname,Upassword,Ugender,Ubirthday,Uemail,Utel,Uaddress,Ugrade,Umajor) values (?,?,?,?,?,?,?,?,?)",Member.getName(),Member.getPassword(),Member.getGender(),Member.getBirthday(),Member.getEmail(),Member.getTel(),Member.getAddress(),Member.getGender(),Member.getMajor());
            return  true;
        }catch (Exception a){
            return false;
        }
    }

    /**
     * 登录
     * @param member
     * @return
     */
    public String login(T_Members member){
        List<String> passwords=jdbcTemplate.query("select Upassword from t_members where Uname='" + member.getName() + "'", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                String u= resultSet.getString("Upassword");
                return u;
            }
        });
        if (passwords.size()==0){
            return "此账户不存在，请确认ID后输入";
        }else {
            if (passwords.get(0).equals(member.getPassword())){
                return "登录成功";
            }else {
                return "密码错误";
            }
        }
    }

    public boolean inputGoods(t_goods goods){
        try{
            jdbcTemplate.update("insert into t_goods  values (?,?,?,?,?,?,?,?,?)" ,goods.getG_id(),goods.getG_name(),goods.getG_brand(),goods.getG_intro(),goods.getG_Area(),goods.getG_price(),goods.getG_date(),goods.getG_place(),goods.getG_weight());
            return true;
        }catch (Exception a){
            return false;
        }
    }

    public List<t_goods> getGoods(){ return jdbcTemplate.query("select * from t_goods",Goods); }


    public t_goods getT_goods(){
        List<t_goods> all=jdbcTemplate.query("select * from t_goods ",Goods);
        t_goods info= all.get(0);
        return info;
    }


}