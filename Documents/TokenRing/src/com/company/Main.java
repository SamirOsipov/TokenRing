package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        int n = 7;
        TokenRing tokenRing = new TokenRing(n);
        tokenRing.startTokenRing();
        for (int i = 0; i < 1000000; i++) {
            tokenRing.sendMessage(new Message(n));
        }
        Thread.sleep(10000);
        tokenRing.stopTokenRing();
    }
}
