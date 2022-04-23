package com.lilb.loser.service;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<ServerResponse> getAllUsers();

    Mono<ServerResponse> addUser(ServerRequest serverRequest);

    Mono<ServerResponse> deleteUser(ServerRequest serverRequest);
}
