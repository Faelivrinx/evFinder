package com.mypieceofcode.evfinder.web;

import com.mypieceofcode.evfinder.domain.User;
import com.mypieceofcode.evfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.http.server.HttpServerResponse;

// TODO: 08.03.2018 Remove when implement redirect after login
@RestController
public class LogoutController {

    @Autowired
    UserRepository repository;

    @GetMapping("/session")
    public String session(WebSession session){

        return session.getId() + " last access time: " + session.getLastAccessTime().toString() + " max idle time: " + session.getMaxIdleTime();
    }

    @PostMapping("/logout")
    public void logout(WebSession session, ServerWebExchange exchange){

        session.invalidate().block();
    }

//
//    @GetMapping("/users")
//    public Flux<User> users(){
//        return repository.findAll();
//    }

    @GetMapping("/")
    public Mono<Void> index(ServerWebExchange exchange){
        exchange.getResponse().setStatusCode(HttpStatus.SEE_OTHER);
        exchange.getResponse().getHeaders().add(HttpHeaders.LOCATION, "/events");
        return exchange.getResponse().setComplete();
    }
}
