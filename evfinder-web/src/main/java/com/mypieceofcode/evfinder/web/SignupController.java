package com.mypieceofcode.evfinder.web;

import com.mypieceofcode.evfinder.domain.User;
import com.mypieceofcode.evfinder.repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.security.SecureRandom;

@RestController
public class SignupController {

    private SecureRandom random = new SecureRandom();
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public SignupController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @PostMapping("/signup")
    public Mono<User> signup(@RequestBody User user){
        return Mono.just(user)
                .subscribeOn(Schedulers.parallel())
                .doOnNext(user1 -> user1.setPassword(this.encoder.encode(user1.getPassword())))
                .flatMap(repository::save)
                .thenReturn(user);
    }
}
