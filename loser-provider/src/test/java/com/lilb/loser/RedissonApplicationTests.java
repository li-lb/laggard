package com.lilb.loser;

import com.lilb.loser.entity.UserEntity;
import com.lilb.loser.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
@Slf4j
class RedissonApplicationTests {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    IUserService iUserService;

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

    @Test
    void test01() throws Exception {
        CompletableFuture<UserEntity> future = iUserService.get(1);
        future.whenCompleteAsync((v,e)->{
            System.out.println("return value:"+v+"  exception:"+e);
        });

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is lambda supplyAsync");
            System.out.println("supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this lambda is executed by forkJoinPool");
            return "result1";
        });
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is task with executor");
            System.out.println("supplyAsync 使用executorService 时是否为守护线程 : " + Thread.currentThread().isDaemon());
            return "result2";
        }, executorService);
        System.out.println(completableFuture.get());
        System.out.println(future.get());
        executorService.shutdown();
    }

}

