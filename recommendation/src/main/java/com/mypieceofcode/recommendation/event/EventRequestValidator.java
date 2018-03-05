package com.mypieceofcode.recommendation.event;

import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.recommendation.exception.ProfileConvertException;

public interface EventRequestValidator {

    boolean validate(IEventRequest request) throws ProfileConvertException;

}
