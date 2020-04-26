package com.example.spring_sandbox;

import lombok.*;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
@ToString(callSuper = true)
public class MyEvent extends ApplicationEvent {
    private String name;
    private String num;

    public MyEvent(Object source, String name, String num) {
        super(source);
        this.name = name;
        this.num = num;
    }
}
