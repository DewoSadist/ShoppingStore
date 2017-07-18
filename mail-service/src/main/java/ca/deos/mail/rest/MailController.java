package ca.deos.mail.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
public class MailController {

    @Value(value = "${spring.profiles.active}")
    String activeProfile;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/api/email-service/email", method = RequestMethod.POST, consumes = "text/plain;charset=UTF-8")
    public void sendEmail(
            @RequestParam(required = true) String destination,
            @RequestParam(required = false) String subject,
            @RequestBody (required = true) String html) throws Exception {
        System.out.println(html);
        new MailUtil(activeProfile).send(destination, subject, html);
    }
}

class MailUtil {

    private String activeProfile;

    public MailUtil(String activeProfile) {
        this.activeProfile = activeProfile;
    }

    public void send(String addressTo, String subject, String body) throws Exception {
        String SMTP_HOST_NAME = null;
        String SMTP_ACCOUNT_ADDRESS = null;
        String SMTP_AUTH_USER = null;
        String SMTP_AUTH_PWD = null;

        Properties props = new Properties();

        if (activeProfile.equals("dev")) {
            SMTP_HOST_NAME = "mail.munchrocket.com";
            SMTP_ACCOUNT_ADDRESS = "noreply@munchrocket.com";
            SMTP_AUTH_USER = "noreply@munchrocket.com";
            SMTP_AUTH_PWD = "(l*Ch3@G,J6q";

            props.put("mail.smtp.start1 `tls.enable", "true");
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", SMTP_HOST_NAME);
            props.put("mail.smtp.auth", "true");
        } else if (activeProfile.equals("test")) {
            SMTP_HOST_NAME = "mail.munchrocket.com";
            SMTP_ACCOUNT_ADDRESS = "noreply@munchrocket.com";
            SMTP_AUTH_USER = "noreply@munchrocket.com";
            SMTP_AUTH_PWD = "(l*Ch3@G,J6q";

            props.put("mail.smtp.start1 `tls.enable", "true");
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", SMTP_HOST_NAME);
            props.put("mail.smtp.auth", "true");
        } else {
            SMTP_HOST_NAME = "mail.munchrocket.com";
            SMTP_ACCOUNT_ADDRESS = "noreply@munchrocket.com";
            SMTP_AUTH_USER = "noreply@munchrocket.com";
            SMTP_AUTH_PWD = "(l*Ch3@G,J6q";

            props.put("mail.smtp.start1 `tls.enable", "true");
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", SMTP_HOST_NAME);
            props.put("mail.smtp.auth", "true");
        }

        Authenticator auth = new SMTPAuthenticator(SMTP_AUTH_USER, SMTP_AUTH_PWD);
        Session mailSession = Session.getDefaultInstance(props, auth);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setContent(body, "text/html; charset=utf-8");
        message.setSubject(subject);
        message.setFrom(new InternetAddress(SMTP_ACCOUNT_ADDRESS));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(addressTo));
        transport.connect();
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }

}
