package com.mypieceofcode.recommendation.utils;

import com.mypieceofcode.evfinder.network.request.RecommendRequest;
import com.mypieceofcode.recommendation.Recommendation;

public interface RecommendationFactory<T extends RecommendRequest> {

    Recommendation recommendation(T t);
}
