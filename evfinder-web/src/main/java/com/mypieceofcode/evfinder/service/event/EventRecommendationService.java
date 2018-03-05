package com.mypieceofcode.evfinder.service.event;

import com.mypieceofcode.evfinder.command.GetEventsCommand;
import com.mypieceofcode.evfinder.domain.Event;
import com.mypieceofcode.evfinder.service.CRUDService;
import reactor.core.publisher.Flux;

public interface EventRecommendationService extends CRUDService<Event> {

    // TODO: 28.02.2018 Command request with coordinate
    Flux<Event> findLocalEventsWithRecommendation(GetEventsCommand eventRequest);
}
