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
public class Zendesk {
    private int newTicket;
    private int openTicket;
    private int pendingTicket;

    public int getNewTicket() {
        return newTicket;
    }

    public void setNewTicket(int newTicket) {
        this.newTicket = newTicket;
    }

    public int getOpenTicket() {
        return openTicket;
    }

    public void setOpenTicket(int openTicket) {
        this.openTicket = openTicket;
    }

    public int getPendingTicket() {
        return pendingTicket;
    }

    public void setPendingTicket(int pendingTicket) {
        this.pendingTicket = pendingTicket;
    }
}
