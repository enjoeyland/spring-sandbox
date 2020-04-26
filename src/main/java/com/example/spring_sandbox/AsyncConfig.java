package com.example.spring_sandbox;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    @Bean(name = "threadPoolTaskExecutor2")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(6);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("jeoyExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }
    //출처: https://medium.com/@pakss328/spring-async-annotation%EC%9D%84-%ED%99%9C%EC%9A%A9%ED%95%9C-thread-%EA%B5%AC%ED%98%84-f5b4766d49c5

    private class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            System.out.println("==============>>>>>>>>>>>> THREAD ERROR");
            System.out.println("Exception Message :: " + throwable.getMessage());
            System.out.println("Method Name :: " + method.getName());
            for (Object param : objects) {
                System.out.println("Parameter Value :: " + param);
            }
            System.out.println("==============>>>>>>>>>>>> THREAD ERROR END");
            // 출처: https://cofs.tistory.com/321 [CofS]
        }
    }
}
