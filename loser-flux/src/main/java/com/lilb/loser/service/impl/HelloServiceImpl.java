package com.lilb.loser.service.impl;

import com.lilb.loser.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String getHelloStr() throws InterruptedException {

        Thread.sleep(2000);
        return "hello";
    }


}
