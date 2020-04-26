package com.example.spring_sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class MyEventPublisher {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public void publish() {
        applicationEventPublisher.publishEvent(new MyEvent(this, "스플렌더", "5"));
    }
}
