package com.mypieceofcode.evfinder.network.request;

import com.mypieceofcode.evfinder.network.model.Coordinate;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class EventsRequest implements IEventRequest {

    private Map<String, Integer> profile;
    private Coordinate coordinate;
    private int searchRadius = 10;

    public EventsRequest() {
    }

    public EventsRequest(@NotNull Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public EventsRequest(Map<String, Integer> profile, @NotNull Coordinate coordinate) {
        this.profile = profile;
        this.coordinate = coordinate;
    }

    public EventsRequest(Map<String, Integer> profile, Coordinate coordinate, int searchRadius) {
        this.profile = profile;
        this.coordinate = coordinate;
        this.searchRadius = searchRadius;
    }

    public int getSearchRadius() {
        return searchRadius;
    }

    public void setSearchRadius(int searchRadius) {
        this.searchRadius = searchRadius;
    }

    @Override
    public Map<String, Integer> getProfile() {
        return profile;
    }

    @Override
    public void setProfile(Map<String, Integer> profile) {
        this.profile = profile;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
