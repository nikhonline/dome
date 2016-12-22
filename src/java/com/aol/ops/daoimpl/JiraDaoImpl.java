/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.daoimpl;

import com.aol.ops.obj.JiraTable;
import com.aol.ops.obj.JiraSnapShot;
import com.aol.ops.obj.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikhil
 */
@Service
public class JiraDaoImpl extends BaseDaoImpl {
    
    public String jiraRaw(){
        Table table=new Table();
        table.setJiraRaw(jiraModel());
        table.setJiraSnapshot(jiraSnapShot());
        return new JSONObject(table).toString();
    }
        
    public List<JiraTable> jiraModel(){
        List<JiraTable> jiraTableList=getJdbcTemplate().query("select TEAM_NAME,CREATED_BY,TICKET,STATUS,ASSIGNED_TO,TICKET_CREATE_TIME,TICKET_UPDATE_TIME,UPDATE_TS from JIRA_CSO_TO_OTHERS;",new RowMapper<JiraTable>(){
            public JiraTable mapRow(ResultSet rs,int rowNum) throws SQLException{
               JiraTable table=new JiraTable();
               table.setAssignee(rs.getString("ASSIGNED_TO"));
               table.setCreateDate(rs.getString("TICKET_CREATE_TIME"));
               table.setCreatorName(rs.getString("CREATED_BY"));
               table.setRefreshTime(rs.getString("TICKET_UPDATE_TIME"));
               table.setStatus(rs.getString("STATUS"));
               table.setTeam(rs.getString("TEAM_NAME"));
               table.setTicketNumber(rs.getString("TICKET"));
               return table;
            }
        });
        return jiraTableList;
    }
    
    public List<JiraSnapShot> jiraSnapShot(){
        List<JiraSnapShot> jiraSnapShotList=getJdbcTemplate().query("select TEAM_NAME,TICKET_TO_OTHERS,OVERALL_OPEN,OVERALL_WIP,OVERALL_STALLED,ONCALL_OPEN,ONCALL_CLOSED,ONCALL_WIP,ONCALL_STALLED,UPDATE_TS from JIRA_CSO_METRICS_SNAPSHOT;",new RowMapper<JiraSnapShot>(){
            public JiraSnapShot mapRow(ResultSet rs,int rowNum) throws SQLException{
               JiraSnapShot snapshot=new JiraSnapShot();
               snapshot.setOncallClosed(rs.getString("ONCALL_CLOSED"));
               snapshot.setOncallOpen(rs.getString("ONCALL_OPEN"));
               snapshot.setOncallStalled(rs.getString("ONCALL_STALLED"));
               snapshot.setOverallOpen(rs.getString("OVERALL_OPEN"));
               snapshot.setOverallStalled(rs.getString("OVERALL_STALLED"));
               snapshot.setOverallWip(rs.getString("OVERALL_WIP"));
               snapshot.setTeam(rs.getString("TEAM_NAME"));
               snapshot.setTicketToOthers(rs.getString("TICKET_TO_OTHERS"));
               snapshot.setUpdateTime(rs.getString("UPDATE_TS"));
               return snapshot;
            }
        });
        return jiraSnapShotList;
    }
    
    
}
