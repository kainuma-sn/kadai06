package com.arias.kadai6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunWaiting3 implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RunWaiting3.class);

    @Override
    public void run() {
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("サブスレッド3(" + i + "/10)");
                Thread.sleep(300);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("RunWaiting3 thread was interrupted", e);
        }
    }
}