package com.arias.kadai6;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // コンストラクタ
    private final RunWaiting1 runWaiting1;
    private final RunWaiting2 runWaiting2;
    private final RunWaiting3 runWaiting3;

    public HelloController(RunWaiting1 runWaiting1, RunWaiting2 runWaiting2, RunWaiting3 runWaiting3) {
        this.runWaiting1 = runWaiting1;
        this.runWaiting2 = runWaiting2;
        this.runWaiting3 = runWaiting3;
    }

    @Async
    @GetMapping("/hello")
    public String exampleAsyncEndpoint() {
        // 3つのスレッドを生成し、実行する
        waitForThreadsToComplete(
                createAndStartThread(runWaiting1),
                createAndStartThread(runWaiting2),
                createAndStartThread(runWaiting3));
        // helloを返す
        return "hello";
    }

    // スレッドの生成
    private Thread createAndStartThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }

    // スレッドの終了待ち
    private void waitForThreadsToComplete(Thread... threads) {
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}


