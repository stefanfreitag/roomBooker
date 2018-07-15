# RoomBooker

https://docs.aws.amazon.com/lex/latest/dg/API_Message.html

//https://www.youtube.com/watch?v=HkMi5xPyz1g
//https://github.com/arun-gupta/lex-java/blob/master/src/main/java/org/sample/aws/lex/response/LexResponse.java

/**
 * https://docs.aws.amazon.com/lex/latest/dg/import-export-format.html
 */

RequestID: aedda1cb-86d0-11e8-ba07-3b2baa37df04
{
  "dialogState": "ConfirmIntent",
  "intentName": "BookRoom",
  "message": "You would like to book a room in Plan H on 2018-07-13 for PT4H starting at 00:12?",
  "messageFormat": "PlainText",
  "responseCard": null,
  "sessionAttributes": {},
  "slotToElicit": null,
  "slots": {
    "slotBuilding": "Plan H",
    "slotDay": "2018-07-13",
    "slotDuration": "PT4H",
    "slotFive": "yes",
    "slotTime": "00:12"
  }
}
