package com.mypieceofcode.evfinder.authentication;

import com.mypieceofcode.evfinder.domain.User;
import com.mypieceofcode.evfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class ReactiveAuthenticationConfig implements ReactiveAuthenticationManager {
    private static final String BCRYPT = "bcrypt";

    private final UserRepository userRepository;
    private final ReactiveAuthenticationManager delegate;
    private final PasswordEncoder encoder;

    public ReactiveAuthenticationConfig(UserRepository userRepository, @Qualifier("repositoryUserDetailService") ReactiveUserDetailsService userDetailsService, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.delegate = createDelegate(userDetailsService, encoder);
        this.encoder = encoder;
    }


    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return this.delegate.authenticate(authentication)
                .delayUntil(this::updatePassword);
    }

    private Mono<User> updatePassword(Authentication authentication) {
        String encodeType = factoryType(encoder);
        return this.userRepository.findByUsername(authentication.getName())
                .publishOn(Schedulers.parallel())
                    .filter(user -> !user.getPassword().contains(encodeType))
                    .doOnNext(user -> user.setPassword(
                        this.encoder.encode(authentication.getCredentials().toString())
                    ))
                .flatMap(this.userRepository::save);
    }

    private ReactiveAuthenticationManager createDelegate(ReactiveUserDetailsService userDetailsService, PasswordEncoder encoder) {
        UserDetailsRepositoryReactiveAuthenticationManager result = new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
        result.setPasswordEncoder(encoder);
        return result;
    }

    // TODO: 09.03.2018 Need update every spring API change
    private String factoryType(PasswordEncoder encoder) {
        if (encoder instanceof BCryptPasswordEncoder) {
            return BCRYPT;
        } else {
            return "";
        }
    }
}
