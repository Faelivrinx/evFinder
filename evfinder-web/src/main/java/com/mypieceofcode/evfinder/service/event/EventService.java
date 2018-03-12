package com.mypieceofcode.evfinder.service.event;

import com.mypieceofcode.evfinder.domain.Event;
import com.mypieceofcode.evfinder.network.request.EventsRequest;
import com.mypieceofcode.evfinder.recommendation.Recommendation;
import com.mypieceofcode.evfinder.recommendation.model.ProfileBuilder;
import com.mypieceofcode.evfinder.recommendation.utils.Const;
import com.mypieceofcode.evfinder.repository.EventRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@Service
public class EventService implements EventRecommendationService {

    private EventRepository eventRepository;
    private Recommendation<Event> recommendation;

    public EventService(EventRepository eventRepository, Recommendation<Event> recommendation) {
        this.eventRepository = eventRepository;
        this.recommendation = recommendation;
    }

    @Override
    public Flux<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Mono<Event> findById(String id) {
        return eventRepository.findById(id);
    }

    @Override
    public Mono<Event> save(Event object) {
        return eventRepository.save(object);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return eventRepository.deleteById(id);
    }

    @Override
    public Flux<Event> saveAll(Event... objects) {
        return eventRepository.saveAll(Flux.just(objects));
    }

    @Override
    public Flux<Event> findLocalEventsWithRecommendation(EventsRequest eventsCommand) {
        Flux<GeoResult<Event>> nearEvents = eventRepository.findByLocationNear(
                new Point(eventsCommand.getCoordinate().getLatitude(), eventsCommand.getCoordinate().getLongitude()),
                new Distance(10, Metrics.KILOMETERS));

        return recommendation.recommended(eventsCommand,
                Flux.just(nearEvents).flatMap(geoResultFlux -> geoResultFlux.map(GeoResult::getContent)));
    }

}
