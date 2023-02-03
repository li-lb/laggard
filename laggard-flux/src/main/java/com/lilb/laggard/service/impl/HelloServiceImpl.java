package com.lilb.laggard.service.impl;

import com.lilb.laggard.service.Hellaggardvice;
import org.springframework.stereotype.Service;

@Service
public class HellaggardviceImpl implements Hellaggardvice {

    @Override
    public String getHelloStr() throws InterruptedException {

        Thread.sleep(2000);
        return "hello";
    }


}
