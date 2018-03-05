package com.mypieceofcode.recommendation.event;

import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.recommendation.utils.Const;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EventRequestValidatorImpl implements EventRequestValidator {
    @Override
    public boolean validate(IEventRequest request) {
        if (request.getCoordinate() == null) {
            return false;
        } else if (request.getProfile() == null || request.getProfile().isEmpty()) {
            return false;
        } else {
            int size = request.getProfile()
                    .keySet().stream()
                    .distinct()
                    .collect(Collectors.toList()).size();
            return size == Const.PROFILE_SIZE;
        }
    }
}
