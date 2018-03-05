package com.mypieceofcode.evfinder.bootstrap;

import com.mypieceofcode.evfinder.service.event.EventService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private EventService eventService;


    public Bootstrap(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void run(String... args) throws Exception {
//        for (int i = 0; i < 20; i++) {
//            Event event = new Event();
//            event.setTitle("Title " + 1);
//            event.setProfile("Profile");
//            event.setDescription("Desc " + 1);
//            event.setDate((long) 423423);
//            eventService.save(event).block();
//        }
    }
}
