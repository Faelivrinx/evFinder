package com.mypieceofcode.evfinder.web.handler;

import com.mypieceofcode.evfinder.command.GetEventsCommand;
import com.mypieceofcode.evfinder.domain.Event;
import com.mypieceofcode.evfinder.service.event.EventRecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(EventHandler.class);

    private EventRecommendationService service;

    public EventHandler(EventRecommendationService service) {
        this.service = service;
    }

    public Mono<ServerResponse> getEvents(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Event.class);
    }

    public Mono<ServerResponse> postEvents(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Event.class);
    }
}
