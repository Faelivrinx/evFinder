package com.mypieceofcode.recommendation.utils;

import com.mypieceofcode.evfinder.network.request.EventsRequest;
import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.recommendation.Recommendation;
import com.mypieceofcode.recommendation.event.EventRecommendation;
import com.mypieceofcode.recommendation.event.EventRequestValidator;
import com.mypieceofcode.recommendation.event.EventRequestValidatorImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class RecommendationFactoryTest {

    private static final IEventRequest SIMPLE_REQUEST = new EventsRequest(null, null);
    private final EventRequestValidator validator = new EventRequestValidatorImpl();

    private RecommendationFactory factory;

    @Before
    public void setUp(){
        factory = new RecommendationFactoryImpl(validator);
    }


    @Test
    public void shouldReturnEventRecWhenEventRequest(){

        Recommendation recommendation = factory.recommendation(SIMPLE_REQUEST);

        assertThat(recommendation, instanceOf(EventRecommendation.class));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenBadRequest(){
        factory.recommendation(null);
    }



}