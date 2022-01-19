package com.lilb.loser;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class RedissonApplicationTests {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void run() throws Exception {
        log.info("spring boot run");

        //创建锁
        RLock helloLock = redissonClient.getLock("hello");

        //加锁
        helloLock.lock();
        try {
            log.info("locked");
            Thread.sleep(1000 * 10);
        } finally {
            //释放锁
            helloLock.unlock();
        }
        log.info("finished");
    }

}

