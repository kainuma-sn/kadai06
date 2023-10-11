package com.arias.kadai6;

public class RunWaiting1 implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("メインスレッド(" + i + "/10)");
                Thread.sleep(200);
            }

        } catch (InterruptedException e) {
        }
    }
}