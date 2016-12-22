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
public class JiraSnapShot {
    private String team;
    private String overallOpen;
    private String overallWip;
    private String overallStalled;
    private String  oncallOpen;
    private String oncallStalled;
    private String oncallClosed;
    private String ticketToOthers;
    private String  updateTime;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getOverallOpen() {
        return overallOpen;
    }

    public void setOverallOpen(String overallOpen) {
        this.overallOpen = overallOpen;
    }

    public String getOverallWip() {
        return overallWip;
    }

    public void setOverallWip(String overallWip) {
        this.overallWip = overallWip;
    }

    public String getOverallStalled() {
        return overallStalled;
    }

    public void setOverallStalled(String overallStalled) {
        this.overallStalled = overallStalled;
    }

    public String getOncallOpen() {
        return oncallOpen;
    }

    public void setOncallOpen(String oncallOpen) {
        this.oncallOpen = oncallOpen;
    }

    public String getOncallStalled() {
        return oncallStalled;
    }

    public void setOncallStalled(String oncallStalled) {
        this.oncallStalled = oncallStalled;
    }

    public String getOncallClosed() {
        return oncallClosed;
    }

    public void setOncallClosed(String oncallClosed) {
        this.oncallClosed = oncallClosed;
    }

    public String getTicketToOthers() {
        return ticketToOthers;
    }

    public void setTicketToOthers(String ticketToOthers) {
        this.ticketToOthers = ticketToOthers;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
