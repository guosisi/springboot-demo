package com.hshbic.ai.task.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: guosidi
 * @date: 2020/8/14 17:46
 */
public class AtomicIntegerServiceTask  implements Runnable {

    private static AtomicInteger count = new AtomicInteger(0);

    private String serviceName;

    AtomicIntegerServiceTask(String serviceName){
        this.serviceName = serviceName;
    }

    @Override
    public void run() {
        if (count.get() >= 5) {
            System.out.println("请求用户过多，请稍后在试！");
        } else {
            try {
                System.out.println("Thread " + serviceName + " is working");
                count.incrementAndGet();
                Thread.sleep(1000);
                System.out.println("Thread " + serviceName + " is over");
            } catch (InterruptedException e) {
                System.out.println("error ...." + e.getMessage());
            }
        }
    }
}
