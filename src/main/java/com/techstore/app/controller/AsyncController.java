package com.techstore.app.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstore.app.services.AsyncService;

//option A Async method execution with @Async and @EnableAsync
@RestController
@RequestMapping("/api")
public class AsyncController {
    private final AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/async-test")
    public String triggerAsync() throws Exception {
        CompletableFuture<String> result = asyncService.doAsyncWork();
        return "Task started! Result: " + result.get();
    }
}
