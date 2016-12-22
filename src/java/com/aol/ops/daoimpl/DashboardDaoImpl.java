/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.daoimpl;

import com.aol.ops.obj.DashboardObj;
import com.aol.ops.obj.Jira;
import com.aol.ops.obj.Zendesk;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikhil
 */
@Service
public class DashboardDaoImpl extends BaseDaoImpl {
    
    public String dashboardRaw(){
        return new JSONObject(dashboardModel()).toString();
    }
    
    public DashboardObj dashboardModel(){
        DashboardObj dashboard=new DashboardObj();
        dashboard.setJira(jira());
        dashboard.setZendesk(zendesk());
        return dashboard;
    }
    
    private List<Jira> jira(){
        List<Jira> jiraList=new ArrayList<Jira>();
        jiraList=this.getJdbcTemplate().query("select TEAM_NAME,OVERALL_OPEN,OVERALL_WIP from JIRA_CSO_METRICS_SNAPSHOT;", new RowMapper<Jira>(){
            public Jira mapRow(ResultSet rs,int rowNum) throws SQLException{
                        Jira jira =new Jira();
                        jira.setTeam(rs.getString("TEAM_NAME"));
                        jira.setOpen(rs.getString("OVERALL_OPEN"));
                        jira.setWip(rs.getString("OVERALL_WIP"));
                        return jira;
            }
        });
        return jiraList;
    }
    
    private List<Zendesk> zendesk(){
        List<Zendesk> zendeskList=new ArrayList<Zendesk>();
        zendeskList=this.getJdbcTemplate().query("select TICKETS_NEW,TICKETS_OPEN,TICKETS_PENDING from ZENDESK_ERP_METRICS_SNAPSHOT where TEAM_NAME='zOverall-Team';;", new RowMapper<Zendesk>(){
            public Zendesk mapRow(ResultSet rs,int rowNum) throws SQLException{
                        Zendesk zendesk =new Zendesk();
                        zendesk.setNewTicket(rs.getInt("TICKETS_NEW"));
                        zendesk.setOpenTicket(rs.getInt("TICKETS_OPEN"));
                        zendesk.setPendingTicket(rs.getInt("TICKETS_PENDING"));
                        return zendesk;
            }
        });
        return zendeskList;
    }
    
}
