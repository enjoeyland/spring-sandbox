package com.example.spring_sandbox;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Slf4j
public class MyAsyncService {
//    @Async("threadPoolTaskExecutor2")
    @Async
    void doAsyncPrintingTask(int i) {
        System.out.println(i +"th task; current thread name : " + Thread.currentThread().getName());
    }

    @Async
    ListenableFuture<Integer> sum(int a, int b) {
        log.info("sum "+ a + " and " + b);
        try {
            Thread.sleep(2000);
            return new AsyncResult<>(a+b);
        } catch (InterruptedException e) {
            return AsyncResult.forExecutionException(e);
        }
    }
}
