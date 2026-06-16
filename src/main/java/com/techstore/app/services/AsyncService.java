package com.techstore.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class AsyncService {

    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public CompletableFuture<String> doAsyncWork() {
        log.info("Async task started on thread: {}", Thread.currentThread().getName());

        try {
            Thread.sleep(3000); // სიმულაცია
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("Async task finished");
        return CompletableFuture.completedFuture("Done!");
    }
}
