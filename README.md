# Room booker

The idea for this room booker demo came up while I was working on another [Alexa](https://en.wikipedia.org/wiki/Amazon_Alexa) Skill. 
I was wondering how this [Amazon Lex](https://aws.amazon.com/de/lex/) could be used
in combination with Alexa. 

## What this demo consists of? 

* A Lex Bot asking the user for reservation details like
  * the building to book a room in
  * the date and time
  * the reservation length
  * necessity of a video conference system. 

* A [Lambda](https://aws.amazon.com/de/lambda/) function that processes the information and sents it as e-mail.
Ideally the Lambda would interface with a real room reservation system, but I do not have any access to one.

## What has Slack to do with this?
The Lex Bot can be integrated with
* [Facebook](https://www.facebook.com/),
* [Kik](https://www.kik.com/),
* [Slack](https://slack.com/intl/de-de),
* [Twilio SMS](https://www.twilio.com/sms)

Slack seemed to be the easiest of the candidates and I used it on a daily base.


## What is required to make this demo run?

### Lex
TODO

### Slack
I followed the steps described in the integration instructions (see Links section) and
added two more permissions

* Access your workspace’s profile information (_users:read_)
* View email addresses of people on this workspace (_users:read.email_)

Both are required to read the relevant information from the Slack user requesting
the reservation: i) the real name and ii) the e-mail address of the user. Latter on is used in
the reply-to field of the send e-mail.


# Links 
* [Amazon Lex Model Building Service](https://docs.aws.amazon.com/lex/latest/dg/API_Types_Amazon_Lex_Model_Building_Service.html)
* [JSON Format for Importing and Exporting Lex related stuff](https://docs.aws.amazon.com/lex/latest/dg/import-export-format.html)
* [Tutorial: AWS Lambda function for Amazon Lex; Implemented on Java](https://www.youtube.com/watch?v=HkMi5xPyz1g)
* [Integrating an Amazon Lex Bot with Slack](https://docs.aws.amazon.com/lex/latest/dg/slack-bot-association.html)
* [Simple Slack API](https://github.com/Ullink/simple-slack-api)
