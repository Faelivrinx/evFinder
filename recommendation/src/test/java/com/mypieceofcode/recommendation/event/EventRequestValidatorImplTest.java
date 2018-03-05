package com.mypieceofcode.recommendation.event;

import com.mypieceofcode.evfinder.network.model.Coordinate;
import com.mypieceofcode.evfinder.network.request.EventsRequest;
import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.recommendation.utils.Const;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

public class EventRequestValidatorImplTest {

    private IEventRequest REQUEST = new EventsRequest(null, null);
    private final Map<String, Integer> VALID_PROFILE = new HashMap<>();
    private final Map<String, Integer> INVALID_PROFILE = new HashMap<>();
    private final Coordinate INVALID_COORDINATE = null;
    private final Coordinate VALID_COORDINATE = new Coordinate();
    private final EventRequestValidator validator = new EventRequestValidatorImpl();


    
    @Before
    public void setUp(){
        for (int i = 0; i < Const.PROFILE_SIZE; i++) {
            VALID_PROFILE.put(String.valueOf(i), new Random().nextInt(6));
        }
        VALID_COORDINATE.setLatitude(23);
        VALID_COORDINATE.setLongitude(23);

        INVALID_PROFILE.put("4", 2);
    }


    @Test
    public void shouldReturnTrueWhenRequestValid() throws Exception{
        REQUEST.setCoordinate(VALID_COORDINATE);
        REQUEST.setProfile(VALID_PROFILE);

        boolean validate = validator.validate(REQUEST);

        Assert.assertEquals(true, validate);
    }

    @Test
    public void shouldReturnFalseWhenProfileNotValid() throws Exception{
        REQUEST.setCoordinate(VALID_COORDINATE);
        REQUEST.setProfile(INVALID_PROFILE);

        boolean validate = validator.validate(REQUEST);

        Assert.assertEquals(false, validate);
    }

    @Test
    public void shouldReturnFalseWhenCoordinateNotValid() throws Exception{
        REQUEST.setCoordinate(INVALID_COORDINATE);
        REQUEST.setProfile(VALID_PROFILE);

        boolean validate = validator.validate(REQUEST);

        Assert.assertEquals(false, validate);
    }



}