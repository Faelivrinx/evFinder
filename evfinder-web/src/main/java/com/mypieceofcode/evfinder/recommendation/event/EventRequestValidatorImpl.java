package com.mypieceofcode.evfinder.recommendation.event;

import com.mypieceofcode.evfinder.network.model.Coordinate;
import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.evfinder.recommendation.exception.ProfileConvertException;
import com.mypieceofcode.evfinder.recommendation.utils.Const;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EventRequestValidatorImpl implements EventRequestValidator {


//    @Override
//    public boolean validate(IEventRequest request) {
//        if (request.getCoordinate() == null) {
//            return false;
//        } else {
//            int size = request.getProfile()
//                    .keySet().stream()
//                    .distinct()
//                    .collect(Collectors.toList()).size();
//            return size == Const.PROFILE_SIZE;
//        }
//    }

    @Override
    public boolean isValidCoordinate(IEventRequest request) {
        return request.getCoordinate() != null;
    }

    @Override
    public boolean isValidProfile(IEventRequest request) throws ProfileConvertException {
        int size = request.getProfile()
                    .keySet().stream()
                    .distinct()
                    .collect(Collectors.toList()).size();
        return size == Const.PROFILE_SIZE;

    }
}
