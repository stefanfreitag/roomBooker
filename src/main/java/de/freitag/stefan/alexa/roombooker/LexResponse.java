package de.freitag.stefan.alexa.roombooker;

import lombok.Data;

@Data
class LexResponse {

  private final DialogAction dialogAction;

  LexResponse(final DialogAction dialogAction) {
    this.dialogAction = dialogAction;
  }
}
