package com.arias.kadai6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunWaiting1 implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RunWaiting1.class);

    @Override
    public void run() {
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("メインスレッド(" + i + "/10)");
                Thread.sleep(200);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("RunWaiting1 thread was interrupted", e);
        }
    }
}