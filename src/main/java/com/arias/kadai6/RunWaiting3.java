package com.arias.kadai6;

public class RunWaiting3 implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("サブスレッド3(" + i + "/10)");
                Thread.sleep(300);
            }

        } catch (InterruptedException e) {
        }
    }
}