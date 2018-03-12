package com.mypieceofcode.evfinder.recommendation.event;

import com.mypieceofcode.evfinder.domain.Event;
import com.mypieceofcode.evfinder.network.request.IEventRequest;
import com.mypieceofcode.evfinder.recommendation.Recommendation;
import com.mypieceofcode.evfinder.recommendation.event.correlation.Correlation;
import com.mypieceofcode.evfinder.recommendation.exception.ProfileConvertException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Comparator;

@Component
public class EventRecommendation implements Recommendation<Event> {

    private final EventRequestValidator validator;

    public EventRecommendation(EventRequestValidator validator) {
        this.validator = validator;
    }

    @Override
    public Flux<Event> recommended(final IEventRequest request, Flux<Event> objectsToRecommend) {
        try {
            if (validator.isValidCoordinate(request)){
                if (validator.isValidProfile(request)){
                    return objectsToRecommend
                            .doOnNext(event -> event.setCorrelation(Correlation.measure(request.getProfile(), event.getProfile())))
                            .sort(Comparator.comparingDouble(Event::getCorrelation));
                } else {
                    return objectsToRecommend
                            .sort(Comparator.comparingDouble(Event::getDate));
                }

            } else {
                return Flux.empty();
            }
        } catch (ProfileConvertException e) {
            e.printStackTrace();
            return Flux.empty();
        }
    }
}
