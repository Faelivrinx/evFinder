package com.mypieceofcode.recommendation.utils;

import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.evfinder.network.request.RecommendRequest;
import com.mypieceofcode.recommendation.Recommendation;
import com.mypieceofcode.recommendation.event.EventRecommendation;
import com.mypieceofcode.recommendation.event.EventRequestValidator;
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
