package com.mypieceofcode.evfinder.command;

import com.mypieceofcode.evfinder.network.model.Coordinate;
import lombok.Data;

@Data
public class GetEventsCommand {

    private String profile;
    private Coordinate coordinate;
    private long searchRadius;
}
