package com.arias.kadai6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunWaiting2 implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RunWaiting2.class);

    @Override
    public void run() {
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("サブスレッド2(" + i + "/10)");
                Thread.sleep(400);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("RunWaiting2 thread was interrupted", e);
        }
    }
}
