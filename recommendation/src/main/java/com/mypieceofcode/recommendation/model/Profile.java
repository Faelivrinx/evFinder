package com.mypieceofcode.recommendation.model;

import java.util.HashMap;
import java.util.Map;

import static com.mypieceofcode.recommendation.utils.Const.*;


public class Profile {

    private final Map<String, Integer> profile = new HashMap<>();

    protected Profile(){ }

    public Map<String, Integer> getProfile() {
        return profile;
    }

}
