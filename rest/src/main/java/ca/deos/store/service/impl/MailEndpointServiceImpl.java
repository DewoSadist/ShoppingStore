package ca.deos.store.service.impl;

import ca.deos.mail.EmailClient;
import ca.deos.mail.service.ReceiptService;
import ca.deos.store.domain.EmailObject;
import ca.deos.store.service.MailEndpointService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MailEndpointServiceImpl implements MailEndpointService {

    @Autowired
    EmailClient emailClient;

    @Autowired
    ReceiptService receiptService;

    Logger log = Logger.getLogger(MailEndpointServiceImpl.class);

    @Override
    public void sendEmailWeb(EmailObject emailObject)  throws IOException, UnirestException {
        log.debug("---------------------------------------------------------");
        log.debug("Begin MailEndpointService.confirmPayment ");
        log.debug("getEmail() = " + emailObject.getDestinationAddress());
        System.out.println("email:" + emailObject.getFrom());
        if(emailObject.getType().equalsIgnoreCase("contact-us")) {

            String body = receiptService.getReceiptContactUs(emailObject);

            EmailObject mail = new EmailObject();
            mail.setDestinationAddress("hello@munchrocket.com");
            mail.setBody(body);
            mail.setSubject("From Munchrocket contact us form");

            log.debug("Send Email for user = " + mail.getDestinationAddress());

            emailClient.sendEmail(mail);
        }

    }

}
