package com.example.spring_sandbox;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MyController {
    @Autowired
    MyEventPublisher myEventPublisher;

    @Autowired
    MyAsyncService myAsyncService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void hihi() {
        myEventPublisher.publish();
    }

    @RequestMapping(value = "/async/void", method = RequestMethod.GET)
    public void callVoidAsyncFunction() {
        for (int i = 0; i <20 ; i++) {
            myAsyncService.doAsyncPrintingTask(i);
        }
        log.info("I'm changed");
        log.info("post commit hook2");
    }

    @RequestMapping(value = "/async/listenableFuture", method = RequestMethod.GET)
    public void callListenableFutureAsyncFunction() {
        ListenableFuture<Integer> result = myAsyncService.sum(10,21);
        result.addCallback(s -> log.info("the result is "+ s), e-> log.info(e.getMessage()));
        log.info("done");
    }

}
