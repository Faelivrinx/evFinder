package com.mypieceofcode.evfinder.service.event;

import com.mypieceofcode.evfinder.command.GetEventsCommand;
import com.mypieceofcode.evfinder.domain.Event;
import com.mypieceofcode.evfinder.repository.EventRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventService implements EventRecommendationService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
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
    public Flux<Event> findLocalEventsWithRecommendation(GetEventsCommand eventsCommand) {
        // TODO: 28.02.2018 search near events and sort

        return null;
    }
}
