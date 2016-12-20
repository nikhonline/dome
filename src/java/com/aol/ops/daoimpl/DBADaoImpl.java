/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.daoimpl;

/**
 *
 * @author Nikhil
 */
public class DBADaoImpl extends BaseDaoImpl{
   
  public void getTicketCount(){
      System.out.println("JDBC Template"+getJdbcTemplate());
  }
}
