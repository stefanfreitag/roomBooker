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



// 2018-07-14 19:42:08 <fe0b03e3-879d-11e8-ab30-4751aba997dc> INFO RoomBookerRequestHandler:28 - bot {name=RoomBookingService, alias=$LATEST, version=$LATEST}

//2018-07-14 19:42:08 <fe0b03e3-879d-11e8-ab30-4751aba997dc> INFO RoomBookerRequestHandler:28 -
// currentIntent {
//  name=BookRoom,
//  slots={slotDuration=PT4H,
//      slotBuilding=Plan H, slotFive=yes, slotDay=2018-07-14, slotTime=07:00},
//      slotDetails={slotDuration={resolutions=[], originalValue=4h},
//      slotBuilding={resolutions=[{value=Plan H}], originalValue=plan h},
//      slotFive={resolutions=[{value=Yes}], originalValue=yes},
// slotDay={resolutions=[], originalValue=today},
// slotTime={resolutions=[], originalValue=7 am}}, confirmationStatus=Confirmed}
