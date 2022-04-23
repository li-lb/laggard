package com.lilb.loser.controller;

import com.lilb.loser.dao.UserRepository;
import com.lilb.loser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/getAllUser",method = RequestMethod.GET)
    public Flux<User> getAllUser() {
        Flux<User> userFlux = userRepository.findAll();
        return userFlux;
    }

    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public Mono<User> addUser(@RequestBody User user) {
        Mono<User> mono = userRepository.save(user);
        return mono;
    }

    /**
     * Flux : 返回0-n个元素
     * 注：需要指定MediaType
     * @return
     */
    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<String> flux() {
        Flux<String> result = Flux
                .fromStream(IntStream.range(1, 5).mapToObj(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    return "flux data--" + i;
                }));
        return result;
    }
}
