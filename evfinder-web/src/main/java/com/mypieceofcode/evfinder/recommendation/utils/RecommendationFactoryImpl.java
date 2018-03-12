package com.mypieceofcode.evfinder.recommendation.utils;

import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.evfinder.network.request.RecommendRequest;
import com.mypieceofcode.evfinder.recommendation.Recommendation;
import com.mypieceofcode.evfinder.recommendation.event.EventRecommendation;
import com.mypieceofcode.evfinder.recommendation.event.EventRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class RecommendationFactoryImpl<T extends RecommendRequest> implements RecommendationFactory<T> {

    private final EventRequestValidator requestValidator;

    public RecommendationFactoryImpl(EventRequestValidator requestValidator) {
        this.requestValidator = requestValidator;
    }

    @Override
    public Recommendation recommendation(T recommendRequest) {
        if (recommendRequest instanceof IEventRequest){
            return new EventRecommendation(requestValidator);
        } else {
            throw new IllegalStateException("Not knowing recommendation system.");
        }

    }

}
