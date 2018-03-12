package com.mypieceofcode.evfinder.service.user;

import com.mypieceofcode.evfinder.domain.User;
import com.mypieceofcode.evfinder.repository.UserRepository;
import com.mypieceofcode.evfinder.service.CRUDService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements CRUDService<User>{

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<User> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<User> save(User object) {
        return repository.save(object);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Flux<User> saveAll(User... objects) {
        return repository.saveAll(Flux.just(objects));
    }
}
