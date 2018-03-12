package com.mypieceofcode.evfinder.network.request;

import com.mypieceofcode.evfinder.network.model.Coordinate;

import java.util.Map;

public interface IEventRequest extends RecommendRequest {
    Map<String, Integer>getProfile();
    void setProfile(Map<String, Integer> profile);
    Coordinate getCoordinate();
    void setCoordinate(Coordinate coordinate);
}
