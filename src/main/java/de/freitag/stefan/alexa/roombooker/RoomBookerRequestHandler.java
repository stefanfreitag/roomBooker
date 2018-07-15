package de.freitag.stefan.alexa.roombooker;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@SuppressWarnings("unused")
public class RoomBookerRequestHandler implements RequestHandler<Map<String, Object>, Object> {

    private static final Logger log = LoggerFactory.getLogger(RoomBookerRequestHandler.class);

    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {

        Map<String, Object> currentIntentMap = (Map<String, Object>) input.get("currentIntent");
        Map<String, Object> slotsMap = (Map<String, Object>) currentIntentMap.get("slots");

        String building = (String) slotsMap.get("slotBuilding");
        String day = (String) slotsMap.get("slotDay");
        String time = (String) slotsMap.get("slotTime");
        String duration = (String) slotsMap.get("slotDuration");
        RoomReservation roomReservation = new RoomReservation(building, day, time, duration, false);
        Mailer.sendMail(roomReservation);
        DialogAction dialogAction = new DialogAction("Close", "Fulfilled", new Message("PlainText", "Request was sent"));
        return new LexResponse(dialogAction);
    }
}

