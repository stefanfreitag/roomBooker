package de.freitag.stefan.alexa.roombooker;


import lombok.Value;

import java.time.Duration;

@Value
public class RoomReservation {

    private String building;
    private String day;
    private String time;
    private Duration duration;
    private boolean vc;

    public RoomReservation(final String building, final String day, final String time, final String duration, final boolean vcRequired) {
        this.building = building;
        this.day = day;
        this.time = time;
        //TODO: Handle DateTimeParseException
        this.duration = Duration.parse(duration);
        this.vc = vcRequired;
    }


}
