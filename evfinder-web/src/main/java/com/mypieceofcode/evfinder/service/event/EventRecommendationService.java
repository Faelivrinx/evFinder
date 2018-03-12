package com.mypieceofcode.evfinder.service.event;

import com.mypieceofcode.evfinder.domain.Event;
import com.mypieceofcode.evfinder.network.request.EventsRequest;
import com.mypieceofcode.evfinder.service.CRUDService;
import reactor.core.publisher.Flux;

public interface EventRecommendationService extends CRUDService<Event> {

    Flux<Event> findLocalEventsWithRecommendation(EventsRequest eventRequest);
}
