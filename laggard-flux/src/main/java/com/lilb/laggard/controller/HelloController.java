package com.lilb.laggard.controller;

import com.lilb.laggard.service.Hellaggardvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    Hellaggardvice hellaggardvice;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Mono<String> hello() {
        long start = System.currentTimeMillis();
        Mono<String> hello = Mono.fromSupplier(() -> {
            try {
                return hellaggardvice.getHelloStr();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("接口耗时：" + (System.currentTimeMillis() - start));
        return hello;
    }


    @RequestMapping(value = "/flux", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        Flux<String> flux = Flux.fromArray(new String[]{"小黑", "小胖", "小六", "一鑫"}).map(s -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "二班：" + s;
        });
        return flux;
    }

}
