/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.daoimpl;

import com.aol.ops.obj.DashboardObj;
import com.aol.ops.obj.Jira;
import com.aol.ops.obj.Zendesk;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikhil
 */
@Service
public class DashboardDaoImpl extends BaseDaoImpl {
    
    public DashboardObj getJIRAChartData(){
        DashboardObj dashboard=new DashboardObj();
        Jira jira =new Jira();
        jira.setLegend("Assigned");
        jira.setValue("10");
        jira.setLegend("Unassigned");
        jira.setValue("11");
        dashboard.setJira(jira);
        Zendesk zendesk=new Zendesk();
        zendesk.setLegend("Assigned");
        zendesk.setValue("10");
        zendesk.setLegend("Unassigned");
        zendesk.setValue("11");
        JSONObject responseJSON=new JSONObject(dashboard);
        System.out.println(responseJSON);
        return null;
    }
}
