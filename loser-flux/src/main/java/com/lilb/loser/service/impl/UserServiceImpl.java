package com.lilb.loser.service.impl;

import com.lilb.loser.dao.UserRepository;
import com.lilb.loser.entity.User;
import com.lilb.loser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Mono<ServerResponse> getAllUsers() {
        return ok().contentType(APPLICATION_JSON)
                .body(userRepository.findAll(), User.class);
    }

    @Override
    public Mono<ServerResponse> addUser(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(userRepository.saveAll(serverRequest.bodyToMono(User.class)), User.class);
    }

    @Override
    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        return userRepository.findById(Integer.valueOf(serverRequest.pathVariable("userId")))
                .flatMap(user -> userRepository.delete(user).then(ok().build()))
                .switchIfEmpty(notFound().build());
    }
}
