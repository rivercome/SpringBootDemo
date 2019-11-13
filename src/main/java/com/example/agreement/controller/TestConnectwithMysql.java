//package com.example.agreement.controller;
//
//
//import com.example.agreement.entity.User;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.jdbc.core.JdbcTemplate;
//import javax.annotation.Resource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Controller
//@RequestMapping("/jdbc")
//public class TestConnectwithMysql {
//    @Resource
//    private JdbcTemplate jdbcTemplate;
//    @RequestMapping("/userlist")
//    public String getUserList(ModelMap map){
//        String sql = "SELECT * FROM user";
//        List <User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
//            User user = null;
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                user = new User();
//                user.setId(rs.getString("id"));
//                user.setName(rs.getString("name"));
//                user.setSex(rs.getString("sex"));
//                user.setAge(rs.getString("age"));
//                return user;
//            }
//        });
//        for (User user:userList){
//            System.out.println(user.getName());
//        }
//        map.addAttribute("users", userList);
//        return  "user";
//    }
//
//
//}
