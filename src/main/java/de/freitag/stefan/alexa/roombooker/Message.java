package de.freitag.stefan.alexa.roombooker;

import lombok.Data;

@Data
class Message {
  /** PlainText or SSML or CustomPayload */
  private final String contentType;

  private final String content;

  Message(final String contentType, final String content) {
    this.contentType = contentType;
    this.content = content;
  }
}
