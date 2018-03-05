package com.mypieceofcode.recommendation;

import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.recommendation.model.RecommendationType;
import reactor.core.publisher.Flux;

public interface Recommendation<Recommentable> {
    Flux<Recommentable> recommended(IEventRequest request, Flux<Recommentable> objectsToRecommend);
}
