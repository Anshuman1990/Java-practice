package com.language.threads;

import java.util.Vector;

public class Producer extends Thread {
    static final int MAX = 7;
    private Vector<String> vector = new Vector<String>();

    @Override
    public void run() {
        try {
            while (true) {

                putMessage();

                sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private synchronized void putMessage() throws InterruptedException {
        while (vector.size() == MAX)
            wait();
        System.out.println("putMessage" + vector.size());
        vector.add("Practice Makes Perfect");
        notify();
    }

    public synchronized String getMessage() throws InterruptedException {
        notify();
        while (vector.size() == 0)
            wait();
        String message = vector.firstElement();

        vector.remove(message);
        System.out.println("getMessage" + vector.size());
        return message;
    }
}
