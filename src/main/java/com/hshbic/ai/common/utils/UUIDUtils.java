package com.hshbic.ai.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 集群下生成UUID
 * @author: guosidi
 * @date: 2020/8/14 11:48
 */
@Slf4j
public class UUIDUtils {

        /* 获取配置：当前实例名 */
        private static final String INSTANCE_NAME = "instance.name";

        private static final AtomicInteger COUNT = new AtomicInteger(0);

        /**
         * 声明private构造方法
         */
        private UUIDUtils() {
        }

        /**
         * 生成集群环境下uuid
         *
         * @return
         */
        public static String generateConcurrentUUID() {
            if (null == INSTANCE_NAME) {
                return "The instance.name JVM option is null";
            }
            String result = null;
            StringBuilder builder = new StringBuilder();
            builder.append(INSTANCE_NAME);
            builder.append(System.currentTimeMillis());
            builder.append(COUNT.incrementAndGet());
            result = builder.toString();
            System.out.println(result);
            try {
                result = UUID.nameUUIDFromBytes(result.getBytes("UTF-8")).toString().replace("-", "");
                UUID.randomUUID();
            } catch (Exception e) {
                log.error("uuid generate exception", e);
            }
            return result;
        }

        public static void main(String[] args){
            System.out.println(generateConcurrentUUID());
        }
}
