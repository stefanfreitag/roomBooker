package de.freitag.stefan.alexa.roombooker;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.SlackUser;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;
import java.io.IOException;
import java.util.Map;

public class RoomBookerRequestHandler implements RequestHandler<Map<String, Object>, Object> {

  @Override
  public Object handleRequest(final Map<String, Object> input, final Context context) {
    String userId = (String) input.get("userId");
    String[] strings = userId.split(":");
    String userName = strings[2];

    // TODO: Run in separate thread

    SlackSession session =
        SlackSessionFactory.createWebSocketSlackSession(System.getenv().get("OAUTH_KEY"));
    SlackUser user = null;
    try {
      session.connect();
      user = session.findUserById(userName);
      session.disconnect();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    Map<String, Object> currentIntentMap = (Map<String, Object>) input.get("currentIntent");
    Map<String, Object> slotsMap = (Map<String, Object>) currentIntentMap.get("slots");

    String building = (String) slotsMap.get("slotBuilding");
    String day = (String) slotsMap.get("slotDay");
    String time = (String) slotsMap.get("slotTime");
    String duration = (String) slotsMap.get("slotDuration");

    RoomReservation roomReservation =
        new RoomReservation(user, building, day, time, duration, false);
    Mailer.sendMail(roomReservation);

    DialogAction dialogAction =
        new DialogAction("Close", "Fulfilled", new Message("PlainText", "Request was sent"));
    return new LexResponse(dialogAction);
  }
}
