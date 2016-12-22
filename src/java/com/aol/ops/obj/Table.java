/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.obj;

import java.util.List;

/**
 *
 * @author Nikhil
 */
public class Table {
    private List<JiraTable> jiraRaw;
    private List<JiraSnapShot> jiraSnapshot;
    private List<ZendeskSnapShot> zendeskSnapshot;
    private List<ZendeskSnapShot> zendeskMetrics;
    private List<ZendeskSnapShot> zendeskErpRequester;

    public List<ZendeskSnapShot> getZendeskMetrics() {
        return zendeskMetrics;
    }

    public void setZendeskMetrics(List<ZendeskSnapShot> zendeskMetrics) {
        this.zendeskMetrics = zendeskMetrics;
    }

    public List<ZendeskSnapShot> getZendeskErpRequester() {
        return zendeskErpRequester;
    }

    public void setZendeskErpRequester(List<ZendeskSnapShot> zendeskErpRequester) {
        this.zendeskErpRequester = zendeskErpRequester;
    }

    public List<JiraTable> getJiraRaw() {
        return jiraRaw;
    }

    public void setJiraRaw(List<JiraTable> jiraRaw) {
        this.jiraRaw = jiraRaw;
    }

    public List<JiraSnapShot> getJiraSnapshot() {
        return jiraSnapshot;
    }

    public void setJiraSnapshot(List<JiraSnapShot> jiraSnapshot) {
        this.jiraSnapshot = jiraSnapshot;
    }

    public List<ZendeskSnapShot> getZendeskSnapshot() {
        return zendeskSnapshot;
    }

    public void setZendeskSnapshot(List<ZendeskSnapShot> zendeskSnapshot) {
        this.zendeskSnapshot = zendeskSnapshot;
    }


}
