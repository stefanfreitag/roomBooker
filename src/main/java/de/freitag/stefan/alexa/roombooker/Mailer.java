package de.freitag.stefan.alexa.roombooker;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

class Mailer {

    private static final Logger log = LoggerFactory.getLogger(Mailer.class);

    private static final MailerConfiguration mailerConfig = new MailerConfiguration();

    static void sendMail(final RoomReservation reservation) {
        final String htmlTextBody = Mailer.generateHtmlTextMessage(reservation);
        log.info("HTML email text: " + htmlTextBody);
        try {
            AmazonSimpleEmailService client =
                    AmazonSimpleEmailServiceClientBuilder.standard()
                            .withRegion(Regions.EU_WEST_1).build();
            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(
                            new Destination().withToAddresses(mailerConfig.getTo()))
                    .withMessage(new com.amazonaws.services.simpleemail.model.Message()
                            .withBody(new Body()
                                    .withHtml(new Content().withCharset("UTF-8").withData(htmlTextBody)))
                            .withSubject(new Content()
                                    .withCharset("UTF-8").withData(mailerConfig.getSubject())))
                    .withSource(mailerConfig.getFrom());
            client.sendEmail(request);
            log.info("An e-mail was sent to " + mailerConfig.getTo());
        } catch (final Exception exception) {
            log.error("The email to " + mailerConfig.getTo() + " was not sent. Error message: "
                    + exception.getMessage());
        }

    }

    static String generateHtmlTextMessage(final RoomReservation reservation) {
        Object[] params = new Object[]{reservation.getBuilding(), reservation.getDay(), reservation.getTime(), reservation.getDuration(), reservation.isVc()};
        return MessageFormat.format(
                "<h3>Hello Stefan,</h3><br />" +
                        "<p>you tried to reserve a room.</p><br />" +
                        "<table border=\"1\">" +
                        "<tr><th colspan=\"2\">Reservation information</th></tr>" +
                        "<tr><td>Building</td><td>{0}</td></tr>" +
                        "<tr><td>Date</td><td>{1}</td></tr>" +
                        "<tr><td>Time</td><td>{2}</td></tr>" +
                        "<tr><td>Duration</td><td>{3}</td></tr>" +
                        "<tr><td>VC required? </td><td>{4}</td></tr>" +
                        "</table>" +
                        "<br />" +
                        "<br />" +
                        "Best regards,<br />" +
                        "<i>The room reservation service</i>", params);
    }

}
