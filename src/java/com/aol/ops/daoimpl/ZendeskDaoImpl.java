/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.daoimpl;

import com.aol.ops.obj.JiraSnapShot;
import com.aol.ops.obj.Table;
import com.aol.ops.obj.ZendeskSnapShot;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikhil
 */
@Service
public class ZendeskDaoImpl extends BaseDaoImpl {
    
  public String zendeskRaw(){
      Table table=new Table();
      table.setZendeskSnapshot(zendeskSnapShot());
      table.setZendeskMetrics(zendeskMetrics());
      table.setZendeskErpRequester(zendeskERPRequester());
      return new JSONObject(table).toString();
  }
  
  public List<ZendeskSnapShot> zendeskSnapShot(){
        List<ZendeskSnapShot> zendeskSnapShotList=getJdbcTemplate().query("select TEAM_NAME,TICKETS_NEW,TICKETS_OPEN,TICKETS_PENDING,TICKETS_CLOSED_120DAYS,UPDATE_TS from ZENDESK_ERP_METRICS_SNAPSHOT;",new RowMapper<ZendeskSnapShot>(){
            public ZendeskSnapShot mapRow(ResultSet rs,int rowNum) throws SQLException{
               ZendeskSnapShot snapShot=new ZendeskSnapShot();
               snapShot.setClosedTickets(rs.getString("TICKETS_CLOSED_120DAYS"));
               snapShot.setNewTickets(rs.getString("TICKETS_NEW"));
               snapShot.setOpenTickets(rs.getString("TICKETS_OPEN"));
               snapShot.setPendingTickets(rs.getString("TICKETS_PENDING"));
               snapShot.setTeamName(rs.getString("TEAM_NAME"));
               snapShot.setUpdatedTime(rs.getString("UPDATE_TS"));
               return snapShot;
            }
        });
        return zendeskSnapShotList;
    }
  
  public List<ZendeskSnapShot> zendeskMetrics(){
        List<ZendeskSnapShot> zendeskSnapShotList=getJdbcTemplate().query("select TYPE,TICKETS_NEW,TICKETS_OPEN,TICKETS_PENDING,TICKETS_CLOSED_120DAYS,UPDATE_TS from ZENDESK_ERP_METRICS_TICKET_TYPES;",new RowMapper<ZendeskSnapShot>(){
            public ZendeskSnapShot mapRow(ResultSet rs,int rowNum) throws SQLException{
               ZendeskSnapShot snapShot=new ZendeskSnapShot();
               snapShot.setClosedTickets(rs.getString("TICKETS_CLOSED_120DAYS"));
               snapShot.setNewTickets(rs.getString("TICKETS_NEW"));
               snapShot.setOpenTickets(rs.getString("TICKETS_OPEN"));
               snapShot.setPendingTickets(rs.getString("TICKETS_PENDING"));
               snapShot.setTeamName(rs.getString("TYPE"));
               snapShot.setUpdatedTime(rs.getString("UPDATE_TS"));
               return snapShot;
            }
        });
        return zendeskSnapShotList;
    }
  
  public List<ZendeskSnapShot> zendeskERPRequester(){
        List<ZendeskSnapShot> zendeskSnapShotList=getJdbcTemplate().query("select TEAM_NAME,TICKETS_NEW,TICKETS_OPEN,TICKETS_PENDING,TICKETS_CLOSED_120DAYS,UPDATE_TS from ZENDESK_ERP_AS_REQUESTER;",new RowMapper<ZendeskSnapShot>(){
            public ZendeskSnapShot mapRow(ResultSet rs,int rowNum) throws SQLException{
               ZendeskSnapShot snapShot=new ZendeskSnapShot();
               snapShot.setClosedTickets(rs.getString("TICKETS_CLOSED_120DAYS"));
               snapShot.setNewTickets(rs.getString("TICKETS_NEW"));
               snapShot.setOpenTickets(rs.getString("TICKETS_OPEN"));
               snapShot.setPendingTickets(rs.getString("TICKETS_PENDING"));
               snapShot.setTeamName(rs.getString("TEAM_NAME"));
               snapShot.setUpdatedTime(rs.getString("UPDATE_TS"));
               return snapShot;
            }
        });
        return zendeskSnapShotList;
    }
  
}
