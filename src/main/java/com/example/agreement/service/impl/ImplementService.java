package com.example.agreement.service.impl;

import com.example.agreement.entity.Agreement;
import com.example.agreement.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ImplementService implements AgreementService {
    /**
     * JDBC 的类
     */

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取所有合同数
     * @return
     */
    @Override
    public String getAllAgreement() {
        return jdbcTemplate.queryForObject("select count(1) from wangpeng_contract", String.class);
    }

    /**
     * 获取合同id
     * @param id 合同id
     * @return
     */
    @Override
    public Agreement getById(int id) {
        String sql = "select * from wangpeng_contract where id = ?";
        List<Agreement> agment = jdbcTemplate.query(sql, new Object[]{id}, new AgreementRowMappe());
        Agreement agreement = null;
        if (!agment.isEmpty()){
            agreement = agment.get(0);
        }
        return agreement;
    }

    /**
     * 新增合同
     * @param agreement 合同
     * @return
     */
    @Override
    public int addAgreement(Agreement agreement) {
        String sql = "insert into wangpeng_contract(content,date,partya,partyb,constract_id) values(?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int resRow = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1,agreement.getContent());
                ps.setString(2,agreement.getTime());
                ps.setString(3,agreement.getPartya());
                ps.setString(4,agreement.getPartyb());
                ps.setInt(5,agreement.getCID());
                return ps;
            }
        }, keyHolder);

        System.out.println("操作记录数："+ resRow + "主键："+ keyHolder.getKey());
        if (resRow > 0){
            // 请求成功
            /**
             * 对order表进行增加操作
             */
//            String sqlorder = "insert into wangpeng_order(num,contract_id) values(?,?)";
////            int resRow2 = jdbcTemplate.update(connection -> {
////                PreparedStatement psorder = connection.prepareStatement(sqlorder, new String[]{"order_id"});
////                psorder.setString(1,agreement.getContent());
////                psorder.setInt(2,  11);
////                return psorder;
////            }, keyHolder);
////            System.out.println("操作记录数："+ resRow2 + "主键："+ keyHolder.getKey());
            return 200;
        }
        else {
            // 请求失败
            return 0;
        }
    }

    /**
     * 更新合同
     * @param agreement 合同
     * @return
     */
    @Override
    public int updateStu(Agreement agreement) {
        String sql = "update wangpeng_contract set content=?, editor=?, editime=? where id=?";
        int res = jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setString(1,agreement.getContent());
            preparedStatement.setString(2,agreement.getEditor());
            preparedStatement.setString(3,agreement.getEditime());
            preparedStatement.setInt(4,agreement.getId());
        });
        if (res > 0){
            // 请求成功

            /**
             * 操作order表更新
             */
            String sqlorder = "update wangpeng_order set num=? where contract_id=?";
            int reorder = jdbcTemplate.update(sqlorder, preparedStatement -> {
                preparedStatement.setString(1,agreement.getContent());
                preparedStatement.setInt(2,agreement.getId());
            });
            System.out.println("操作记录数："+ reorder);
            return 200;
        }
        else {
            // 请求失败
            return 0;
        }
    }
}


class AgreementRowMappe implements RowMapper<Agreement> {

    @Override
    public Agreement mapRow(ResultSet resultSet, int i) throws SQLException {
        Agreement stu = new Agreement();
        stu.setId(resultSet.getInt("id"));
        return stu;
    }
}