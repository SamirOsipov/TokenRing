package com.company;

import java.util.Iterator;
import java.util.List;

public class Node {
    public static volatile boolean run = true;
    private List<Message> getList;
    private List<Message> putList;
    private TokenRing tokenRing;

    public Node(List<Message> getList, List<Message> putList, TokenRing tokenRing) {
        this.getList = getList;
        this.putList = putList;
        this.tokenRing = tokenRing;
    }

    public void run() {
        while (Node.run) {
            if (!getList.isEmpty()) {
                Message message;
                synchronized (getList) {
                    Iterator<Message> iterator = getList.iterator();
                    message = iterator.next();
                    iterator.remove();
                }
                message.decPrevNodes();
                if (!message.isFinished()) {
                    synchronized (putList) {
                        putList.add(message);
                    }
                }
            }
        }
    }
}
