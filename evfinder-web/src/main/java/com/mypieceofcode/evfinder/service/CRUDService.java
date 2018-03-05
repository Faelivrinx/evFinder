package com.mypieceofcode.evfinder.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CRUDService<T> {

    Flux<T> findAll();

    Mono<T> findById(String id);

    Mono<T> save(T object);

    Mono<Void> deleteById(String id);

    Flux<T> saveAll(T... objects);
}
