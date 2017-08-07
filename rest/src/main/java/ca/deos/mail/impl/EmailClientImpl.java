package ca.deos.mail.impl;

import ca.deos.mail.EmailClient;
import ca.deos.store.domain.EmailObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmailClientImpl implements EmailClient{

    final String EMAIL_URL = "http://localhost:8083/api/email-service/email";

    @Override
    public void sendEmail(EmailObject object) throws JsonProcessingException,
            UnirestException, IOException {
        System.out.println(EMAIL_URL + "\n" +  object.getDestinationAddress());
        HttpResponse<String> response = Unirest
                .post(EMAIL_URL)
                .queryString("destination", object.getDestinationAddress())
                .queryString("subject", object.getSubject())
                .header("Content-Type", "text/plain;charset=utf-8")
                .body(object.getBody()).asString();
        System.out.println(object.getBody());
        System.out.println(response.getStatus() + " " + response.getStatusText() + response.getBody());

    }
}
