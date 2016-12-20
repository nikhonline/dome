/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.dome.controller;


import com.aol.ops.daoimpl.DBADaoImpl;
import com.aol.ops.daoimpl.DashboardDaoImpl;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 *
 * @author Nikhil
 */
@Controller
public class OpsController {
  
  //ApplicationContext context=new ClassPathXmlApplicationContext("WEB-INF/applicationContext");
    
  private DashboardDaoImpl dashboardDaoImpl;
  
  @Autowired
  public void setDashboardDaoImpl(DashboardDaoImpl dashboardDaoImpl){
      this.dashboardDaoImpl=dashboardDaoImpl;
  }
  
  
  
  @RequestMapping(value="/jiraMetrics",method=RequestMethod.GET)  
  public @ResponseBody String jiraMetrics(String requestObj){
      URL resource=getClass().getResource("/");
      System.out.println(resource.getPath());
      dashboardDaoImpl.getJIRAChartData();
      //DBADaoImpl db=(DBADaoImpl)context.getBean("dbDao");
      //db.getTicketCount();
      return "home";
  }
}
