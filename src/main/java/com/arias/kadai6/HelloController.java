package com.arias.kadai6;


import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Async
    @GetMapping("/hello")
    public String exampleAsyncEndpoint() {

        //クラスインスタンスの生成
        RunWaiting1 runWaiting1 = new RunWaiting1();
        RunWaiting2 runWaiting2 = new RunWaiting2();
        RunWaiting3 runWaiting3 = new RunWaiting3();

        //スレッドの生成
        Thread thread1 = new Thread(runWaiting1);
        Thread thread2 = new Thread(runWaiting2);
        Thread thread3 = new Thread(runWaiting3);

        //スレッドの開始
        thread1.start();
        thread2.start();
        thread3.start();


        //スレッドが終了するまで待機
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //helloを返す
        return "hello";
    }
}
