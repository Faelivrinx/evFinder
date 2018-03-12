package com.mypieceofcode.evfinder.recommendation.event;

import com.mypieceofcode.evfinder.network.model.Coordinate;
import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.evfinder.recommendation.exception.ProfileConvertException;

import java.util.Map;

public interface EventRequestValidator {

    boolean isValidCoordinate(IEventRequest request);
    boolean isValidProfile(IEventRequest request) throws ProfileConvertException;
}
