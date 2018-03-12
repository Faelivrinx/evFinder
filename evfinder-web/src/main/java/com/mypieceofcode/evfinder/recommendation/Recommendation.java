package com.mypieceofcode.evfinder.recommendation;

import com.mypieceofcode.evfinder.network.request.IEventRequest;
import reactor.core.publisher.Flux;

public interface Recommendation<Recommentable> {
    Flux<Recommentable> recommended(IEventRequest request, Flux<Recommentable> objectsToRecommend);
}
