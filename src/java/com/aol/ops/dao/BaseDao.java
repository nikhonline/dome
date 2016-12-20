/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nikhil
 */
public interface BaseDao {
    public JdbcTemplate getJdbcTemplate();
    public void setOpsDataSource(DataSource dataSource);
}
