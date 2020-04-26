package com.example.spring_sandbox;

import org.springframework.scheduling.annotation.Async;

public class AsyncService {
    @Async
    public void run(Runnable runnable) {
        runnable.run();
    }// 출처: https://jeong-pro.tistory.com/187 [기본기를 쌓는 정아마추어 코딩블로그]
}
