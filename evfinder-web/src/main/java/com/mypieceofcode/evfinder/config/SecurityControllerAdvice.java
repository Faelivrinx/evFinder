package com.mypieceofcode.evfinder.config;

import com.mypieceofcode.evfinder.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.reactive.result.view.CsrfRequestDataValueProcessor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

// TODO: 08.03.2018 Probably unnesessary. Spring team already correct csrf. To REMOVE!
@Deprecated
@ControllerAdvice
public class SecurityControllerAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(SecurityControllerAdvice.class.getName());
    private Mono<Principal> currentUser;

//    @ModelAttribute
//    Mono<CsrfToken> csrfToken(ServerWebExchange exchange) {
//        Mono<CsrfToken> csrfToken = exchange.getAttribute(CsrfToken.class.getName());
//        return csrfToken
//                .doOnSuccess(token -> exchange.getAttributes()
//                        .put(CsrfRequestDataValueProcessor.DEFAULT_CSRF_ATTR_NAME, token)
//                );
//    }
//
//    @ModelAttribute("/user")
//    Mono<Map> currentUser(@AuthenticationPrincipal Mono<User> currentUser) {
//        return currentUser
//                .map(user -> {
//                    Map<String, Object> map = new HashMap<>();
//                    map.put("name", user.getUsername());
//                    map.put("roles", AuthorityUtils.authorityListToSet(((Authentication) user)
//                            .getAuthorities()));
//                    return map;
//                });
//    }
}
