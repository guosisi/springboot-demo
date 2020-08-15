package com.hshbic.ai.task.atomicInteger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: AtomicInteger方式
 * @author: guosidi
 * @date: 2020/8/14 17:47
 */
public class AtomicIntegerRateLimiterDemo {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for(int i = 1 ; i <= 1000 ; i++){
            AtomicIntegerServiceTask serviceTask = new AtomicIntegerServiceTask("task" + i);
            executor.submit(serviceTask);
        }
    }
}
