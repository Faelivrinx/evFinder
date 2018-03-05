package com.mypieceofcode.recommendation.model;

import static com.mypieceofcode.recommendation.utils.Const.*;
import static com.mypieceofcode.recommendation.utils.Const.A_VARIOUS;
import static com.mypieceofcode.recommendation.utils.Const.A_YOGA;

public class ProfileBuilder {
    private Profile profile;

    public ProfileBuilder() {
    }

    public ProfileBuilder builder(){
        if (profile == null){
            profile = new Profile();
            profile.getProfile().put(S_FOOTBALL, 0);
            profile.getProfile().put(S_VOLLEYBALL, 0);
            profile.getProfile().put(S_HANDBALL, 0);
            profile.getProfile().put(S_BASKETBALL, 0);
            profile.getProfile().put(S_TENNIS, 0);
            profile.getProfile().put(S_TABLE_TENNIS, 0);
            profile.getProfile().put(S_RUGBY, 0);
            profile.getProfile().put(S_ATHLETICS, 0);
            profile.getProfile().put(S_HOCKEY, 0);
            profile.getProfile().put(S_VARIOUS, 0);
            profile.getProfile().put(M_ROCK, 0);
            profile.getProfile().put(M_POP, 0);
            profile.getProfile().put(M_METAL, 0);
            profile.getProfile().put(M_DISCO_POLO, 0);
            profile.getProfile().put(M_FILM, 0);
            profile.getProfile().put(M_CLASSIC, 0);
            profile.getProfile().put(M_HIP_HOP, 0);
            profile.getProfile().put(M_BLUES, 0);
            profile.getProfile().put(M_COUNTRY, 0);
            profile.getProfile().put(M_JAZZ, 0);
            profile.getProfile().put(M_TECHNO, 0);
            profile.getProfile().put(M_VARIOUS, 0);
            profile.getProfile().put(C_ART, 0);
            profile.getProfile().put(C_EDUCATION, 0);
            profile.getProfile().put(C_LOCAL_CULTURE, 0);
            profile.getProfile().put(C_CINEMA, 0);
            profile.getProfile().put(C_THEATRE, 0);
            profile.getProfile().put(C_DANCE, 0);
            profile.getProfile().put(C_CHILDREN, 0);
            profile.getProfile().put(C_LITERATURE, 0);
            profile.getProfile().put(C_VARIOUS, 0);
            profile.getProfile().put(A_FOOTBALL, 0);
            profile.getProfile().put(A_VOLLEYBALL, 0);
            profile.getProfile().put(A_HANDBALL, 0);
            profile.getProfile().put(A_BASKETBALL, 0);
            profile.getProfile().put(A_TENNIS, 0);
            profile.getProfile().put(A_TABLE_TENNIS, 0);
            profile.getProfile().put(A_RUGBY, 0);
            profile.getProfile().put(A_ATHLETICS, 0);
            profile.getProfile().put(A_HOCKEY, 0);
            profile.getProfile().put(A_RUNNING, 0);
            profile.getProfile().put(A_BIKING, 0);
            profile.getProfile().put(A_SWIMMING, 0);
            profile.getProfile().put(A_YOGA, 0);
            profile.getProfile().put(A_VARIOUS, 0);
        }

        return this;
    }

    public ProfileBuilder setValue(String key, Integer value){
        if (value > 0 && value < 7){
            profile.getProfile().put(key, value);
            return this;
        }
        return this;
    }

    public Profile build() {
        if (profile == null){
            builder();
        }
        return profile;
    }
}
