package com.mypieceofcode.evfinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.web.server.session.HeaderWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

// TODO: 08.03.2018 Check header sesion authentication. Just for fun!

@Configuration
//@EnableRedisWebSession
public class SessionConfig {

//    @Bean
//    public WebSessionIdResolver webSessionIdResolver(){
//        HeaderWebSessionIdResolver resolver = new HeaderWebSessionIdResolver();
//        resolver.setHeaderName("X-AUTH-TOKEN");
//        return resolver;
//    }
}
