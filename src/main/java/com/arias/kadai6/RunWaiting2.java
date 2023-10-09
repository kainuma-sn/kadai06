package com.arias.kadai6;

public class RunWaiting2 implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("サブスレッド2(" + i + "/10)");
                Thread.sleep(800);
            }

        } catch (InterruptedException e) {
        }
    }
}
