package com.company;

import java.util.Date;

public class Message {
    private int prevNodes;
    private Date date;

    public Message(int prevNodes) {
        this.prevNodes = prevNodes;
        this.date = new Date();
    }

    public synchronized void decPrevNodes() {
        this.prevNodes--;
    }

    public boolean isFinished() {
        return prevNodes <= 0;
    }

    public Date getDate() {
        return date;
    }
}
