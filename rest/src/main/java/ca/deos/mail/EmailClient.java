package ca.deos.mail;

import ca.deos.store.domain.EmailObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public interface EmailClient {

    public void sendEmail(EmailObject object) throws JsonProcessingException,
            UnirestException, IOException;

}
