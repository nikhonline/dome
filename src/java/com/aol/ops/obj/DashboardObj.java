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
public class DashboardObj {
    private Jira jira;
    private Nagios nagios;
    private Zendesk zendesk;
    private Goanywhere goanywhere;

    public Jira getJira() {
        return jira;
    }

    public void setJira(Jira jira) {
        this.jira = jira;
    }

    public Nagios getNagios() {
        return nagios;
    }

    public void setNagios(Nagios nagios) {
        this.nagios = nagios;
    }

    public Zendesk getZendesk() {
        return zendesk;
    }

    public void setZendesk(Zendesk zendesk) {
        this.zendesk = zendesk;
    }

    public Goanywhere getGoanywhere() {
        return goanywhere;
    }

    public void setGoanywhere(Goanywhere goanywhere) {
        this.goanywhere = goanywhere;
    }
    
}
