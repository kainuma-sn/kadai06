package com.arias.kadai6;

public class RunWaiting3 implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("サブスレッド2(" + i + "/10)");
                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
        }
    }
}