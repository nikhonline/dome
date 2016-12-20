/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.daoimpl;

import com.aol.ops.dao.BaseDao;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nikhil
 */
@Component
public class BaseDaoImpl implements BaseDao{
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setOpsDataSource(DataSource datasource) {
        jdbcTemplate=new JdbcTemplate(datasource);
    }
    
}
