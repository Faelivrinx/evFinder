package com.mypieceofcode.recommendation.event;

import com.mypieceofcode.evfinder.domain.Event;
import com.mypieceofcode.evfinder.network.model.Coordinate;
import com.mypieceofcode.evfinder.network.request.EventsRequest;
import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.recommendation.model.Profile;
import com.mypieceofcode.recommendation.model.ProfileBuilder;
import com.mypieceofcode.recommendation.utils.Const;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class EventRecommendationTest {

    private IEventRequest REQUEST = new EventsRequest(null, null);
    private final Profile USER_PROFILE = new ProfileBuilder().builder()
            .setValue(Const.S_FOOTBALL, 6)
            .setValue(Const.M_ROCK, 6)
            .setValue(Const.A_RUNNING, 4).build();

    private Event firstEvent;
    private Event secondEvent;


    private final Coordinate INVALID_COORDINATE = null;
    private final Coordinate VALID_COORDINATE = new Coordinate();

    private EventRequestValidator validator;
    private EventRecommendation eventRecommendation;

    @Before
    public void setUp(){
        validator = Mockito.mock(EventRequestValidator.class);
        eventRecommendation = new EventRecommendation(validator);
        REQUEST.setProfile(USER_PROFILE.getProfile());
        VALID_COORDINATE.setLatitude(23);
        VALID_COORDINATE.setLongitude(23);

        firstEvent = new Event.EventBuilder().build();
        firstEvent.setProfile(new ProfileBuilder().builder().setValue(Const.A_FOOTBALL, 6).build().getProfile());
        secondEvent = new Event.EventBuilder().build();
        secondEvent.setProfile(new ProfileBuilder().builder().setValue(Const.A_RUNNING, 6).build().getProfile());
    }

    @Test
    public void shouldEmmitEventsWhenValidData() throws Exception{
        Mockito.when(validator.validate(REQUEST)).thenReturn(true);

        Flux<Event> result= eventRecommendation.recommended(REQUEST, (Flux.just(firstEvent, secondEvent)));

        StepVerifier.create(result)
                .expectNext(firstEvent)
                .expectNext(secondEvent)
                .verifyComplete();
    }

    @Test
    public void shouldEmmitEmptyWhenNotValidData() throws Exception{
        Mockito.when(validator.validate(REQUEST)).thenReturn(false);

        Flux<Event> result = eventRecommendation.recommended(REQUEST, Flux.just(firstEvent, secondEvent));

        StepVerifier.create(result)
                .expectNextCount(0)
                .verifyComplete();
    }

}