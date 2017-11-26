package com.company;

import java.util.ArrayList;
import java.util.List;

public class TokenRing {
    private List<Message>[] messageLists;
    private Thread[] nodes;

    public TokenRing(int n) {
        messageLists = new ArrayList[n];
        nodes = new Thread[n];
        for (int i = 0; i < n; i++) {
            messageLists[i] = new ArrayList<Message>();
        }
        for (int i = 0; i < n - 1; i++) {
            nodes[i] = new Thread(String.valueOf(new Node(messageLists[i], messageLists[i + 1 ], this)));
        }
        nodes[n - 1] = new Thread(String.valueOf(new Node(messageLists[n - 1], messageLists[0],this)));
    }

    public void startTokenRing() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].start();
        }
    }

    public void stopTokenRing() {
        Node.run = false;
    }

    public void sendMessage(Message message) {
        synchronized (messageLists[0]) {
            messageLists[0].add(message);
        }
    }
}
