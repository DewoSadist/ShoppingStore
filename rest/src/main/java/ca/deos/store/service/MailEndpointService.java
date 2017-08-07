package ca.deos.store.service;

import ca.deos.store.domain.EmailObject;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public interface MailEndpointService {
    
    public void sendEmailWeb(EmailObject emailObject) throws IOException, UnirestException;
    
}
