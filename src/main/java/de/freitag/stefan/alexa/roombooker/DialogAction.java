package de.freitag.stefan.alexa.roombooker;

import lombok.Value;

@Value
class DialogAction {

  private final String type;
  private final String fulfillmentState;
  private final Message message;

  DialogAction(final String type, final String fulfillmentState, final Message message) {
    this.type = type;
    this.fulfillmentState = fulfillmentState;
    this.message = message;
  }
}
