/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.ops.obj;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikhil
 */
public class DashboardObj {
    private List<Jira> jira;
    private List<Nagios> nagios;
    private List<Zendesk> zendesk;
    private List<Goanywhere> goanywhere;

    public List<Jira> getJira() {
        return jira;
    }

    public void setJira(List<Jira> jira) {
        this.jira = jira;
    }

    public List<Nagios> getNagios() {
        return nagios;
    }

    public void setNagios(List<Nagios> nagios) {
        this.nagios = nagios;
    }

    public List<Zendesk> getZendesk() {
        return zendesk;
    }

    public void setZendesk(List<Zendesk> zendesk) {
        this.zendesk = zendesk;
    }

    public List<Goanywhere> getGoanywhere() {
        return goanywhere;
    }

    public void setGoanywhere(List<Goanywhere> goanywhere) {
        this.goanywhere = goanywhere;
    }


     
}
