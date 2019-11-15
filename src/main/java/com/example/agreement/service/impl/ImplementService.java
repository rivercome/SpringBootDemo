package com.example.agreement.service.impl;

import com.example.agreement.Exception.ErrorParamsException;
import com.example.agreement.Exception.ServiceException;
import com.example.agreement.entity.Agreement;
import com.example.agreement.service.AgreementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ImplementService implements AgreementService {
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
        List<Agreement> responseAgreement = jdbcTemplate.query(sql, new Object[]{id}, new AgreementRowMappe());
        Agreement agreement = null;
        if (!responseAgreement.isEmpty()){
            agreement = responseAgreement.get(0);
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
        if (agreement.getContent() == null || agreement.getDate()  == null || agreement.getPartya() == null || agreement.getPartyb() == null || agreement.getContrast_id() == null  ){
            throw new ErrorParamsException("新增合同");
        }
        String sql = "insert into wangpeng_contract(content,createdate,partya,partyb,constract_id) values(?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int resRow = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1,agreement.getContent());
                ps.setString(2,agreement.getDate());
                ps.setString(3,agreement.getPartya());
                ps.setString(4,agreement.getPartyb());
                ps.setInt(5,agreement.getContrast_id());
                return ps;
            }
        }, keyHolder);
        if (resRow > 0){
            // 请求成功
            /**
             * 对order表进行增加操作
             */


            /**
             * JDBC 插入值返回主键
             */
            if (keyHolder.getKey() == null){
                return 0;
            }
            Number number = keyHolder.getKey();

            Long id = number.longValue();

            String sqlorder = "insert into wangpeng_order(num,contract_id) values(?,?)";
            int resRow2 = jdbcTemplate.update(connection -> {
                PreparedStatement psorder = connection.prepareStatement(sqlorder, new String[]{"order_id"});
                psorder.setString(1,agreement.getContent());
                psorder.setInt(2, Math.toIntExact(id));
                return psorder;
            }, keyHolder);
            return 200;
        }
        else {
            // 请求失败
            throw new ServiceException(agreement.getId());
        }
    }

    /**
     * 更新合同
     * @param agreement 合同
     * @return
     */
    @Override
    public int updateAgreement(Agreement agreement) {
        if (agreement.getEditime() == null || agreement.getEditor() == null) {
            throw new  ErrorParamsException("更新合同");
        }
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
                preparedStatement.setInt(2, agreement.getId());
            });
            return 200;
        }
        else {
            // 请求失败
            throw new ServiceException(agreement.getId());
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