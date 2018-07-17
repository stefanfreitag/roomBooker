package de.freitag.stefan.alexa.roombooker;


import com.ullink.slack.simpleslackapi.SlackUser;
import lombok.Value;

import java.time.Duration;

@Value
class RoomReservation {

    private final SlackUser user;
    private final String building;
    private final String day;
    private final String time;
    private final Duration duration;
    private final boolean vcRequired;

    RoomReservation(final SlackUser user, final String building, final String day, final String time, final String duration, final boolean vcRequired) {
        this.user = user;
        this.building = building;
        this.day = day;
        this.time = time;
        this.duration = Duration.parse(duration);
        this.vcRequired = vcRequired;
    }

}
