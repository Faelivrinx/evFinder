package com.mypieceofcode.evfinder.bootstrap;

import com.mypieceofcode.evfinder.domain.User;
import com.mypieceofcode.evfinder.repository.UserRepository;
import com.mypieceofcode.evfinder.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    private EventService eventService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

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

        userRepository.deleteAll()
                .thenMany(Flux.just("user", "admin"))
                .flatMap(
                        username -> {
                            List<String> roles = "user".equals(username)
                                    ? Arrays.asList("ROLE_USER")
                                    : Arrays.asList("ROLE_USER", "ROLE_ADMIN");

                            User user = User.builder()
                                    .roles(roles)
                                    .username(username)
                                    .password(encoder.encode("password"))
                                    .email(username + "@example.com")
                                    .build();
                            return this.userRepository.save(user);
                        }
                )

    .log()
                .subscribe(
                        null,
                        null,
                        () -> {}
                );
    }
}
