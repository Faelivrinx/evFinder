package com.mypieceofcode.evfinder.repository;

import com.mypieceofcode.evfinder.domain.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EventRepository extends ReactiveMongoRepository<Event, String> {
}
