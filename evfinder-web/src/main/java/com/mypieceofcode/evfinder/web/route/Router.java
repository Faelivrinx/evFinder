package com.mypieceofcode.evfinder.web.route;

import com.mypieceofcode.evfinder.web.handler.EventHandler;
import com.mypieceofcode.evfinder.web.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class Router {

    @Bean
    RouterFunction<ServerResponse>routeEvents(EventHandler eventHandler){
        return RouterFunctions
                .route(GET("/events").and(accept(MediaType.APPLICATION_JSON)), eventHandler::getEvents)
                .andRoute(POST("/events").and(accept(MediaType.APPLICATION_JSON)), eventHandler::postEvents);
    }

    @Bean
    RouterFunction<ServerResponse> routeUsers(UserHandler handler){
        return RouterFunctions
                .route(RequestPredicates.GET("/users")
                        .and(accept(MediaType.APPLICATION_JSON)), handler::getUsers)
                .andRoute(GET("/user/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)), handler::getUserById);
    }
}
