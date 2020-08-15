package com.hshbic.ai.task.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: Semaphore方式
 * @author: guosidi
 * @date: 2020/8/15 17:10
 */
public class SemaphoreCountLimiterDemo {

    public static void main(String[] args){
        ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for(int i = 1 ; i <= 100 ; i++){
            SemaphoreServiceTask serviceTask = new SemaphoreServiceTask("task" + i);
            executor.submit(serviceTask);
        }
    }

}
