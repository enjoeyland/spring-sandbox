package com.example.spring_sandbox;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    public void handle(MyEvent event) {
        System.out.println("Event received!" + event.toString());
    }
}
