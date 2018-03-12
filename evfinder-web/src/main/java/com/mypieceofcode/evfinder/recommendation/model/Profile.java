package com.mypieceofcode.evfinder.recommendation.model;

import java.util.HashMap;
import java.util.Map;



public class Profile {

    private final Map<String, Integer> profile = new HashMap<>();

    protected Profile(){ }

    public Map<String, Integer> getProfile() {
        return profile;
    }

}
