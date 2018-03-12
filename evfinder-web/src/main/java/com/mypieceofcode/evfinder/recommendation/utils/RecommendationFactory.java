package com.mypieceofcode.evfinder.recommendation.utils;

import com.mypieceofcode.evfinder.network.request.RecommendRequest;
import com.mypieceofcode.evfinder.recommendation.Recommendation;

public interface RecommendationFactory<T extends RecommendRequest> {

    Recommendation recommendation(T t);
}
