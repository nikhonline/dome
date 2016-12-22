/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.dome.controller;


import com.aol.ops.daoimpl.DashboardDaoImpl;
import com.aol.ops.daoimpl.JiraDaoImpl;
import com.aol.ops.daoimpl.ZendeskDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
  private JiraDaoImpl jiraDaoImpl;
  private ZendeskDaoImpl zendeskDaoImpl;
  
  @Autowired
  public void setDashboardDaoImpl(DashboardDaoImpl dashboardDaoImpl){
      this.dashboardDaoImpl=dashboardDaoImpl;
  }
  
  @Autowired
  public void setJiraDaoImpl(JiraDaoImpl jiraDaoImpl){
      this.jiraDaoImpl=jiraDaoImpl;
  }
  
  @Autowired
  public void setZendeskDaoImpl(ZendeskDaoImpl zendeskDaoImpl){
      this.zendeskDaoImpl=zendeskDaoImpl;
  }
  
  
  
  @RequestMapping(value="/erp",method=RequestMethod.GET)  
  public @ResponseBody String erp(String req){
      long startTime=System.currentTimeMillis();
      String rawData=dashboardDaoImpl.dashboardRaw();
      long endTime=System.currentTimeMillis();
      System.out.println("Response Time for /erp: "+(endTime-startTime)/1000);
      return "["+rawData+"]";
  }
  
  @RequestMapping(value="/jira",method=RequestMethod.GET)
  public @ResponseBody String jira(String req){
       return jiraDaoImpl.jiraRaw();
  }
  
  @RequestMapping(value="/zendesk",method=RequestMethod.GET)
  public @ResponseBody String zendesk(String req){
      return zendeskDaoImpl.zendeskRaw();
  }
}
