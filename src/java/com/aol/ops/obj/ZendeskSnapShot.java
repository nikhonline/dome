/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.obj;

/**
 *
 * @author Nikhil
 */
public class ZendeskSnapShot {

    private String teamName;
    private String newTickets;
    private String openTickets;
    private String pendingTickets;
    private String closedTickets;
    private String updatedTime;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getNewTickets() {
        return newTickets;
    }

    public void setNewTickets(String newTickets) {
        this.newTickets = newTickets;
    }

    public String getOpenTickets() {
        return openTickets;
    }

    public void setOpenTickets(String openTickets) {
        this.openTickets = openTickets;
    }

    public String getPendingTickets() {
        return pendingTickets;
    }

    public void setPendingTickets(String pendingTickets) {
        this.pendingTickets = pendingTickets;
    }

    public String getClosedTickets() {
        return closedTickets;
    }

    public void setClosedTickets(String closedTickets) {
        this.closedTickets = closedTickets;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

}
