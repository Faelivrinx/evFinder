package com.mypieceofcode.evfinder.repository;

import com.mypieceofcode.evfinder.domain.Event;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface EventRepository extends ReactiveMongoRepository<Event, String> {
    Flux<GeoResult<Event>> findByLocationNear(Point point, Distance distance);
}
