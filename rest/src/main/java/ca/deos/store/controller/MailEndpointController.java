package ca.deos.store.controller;

import ca.deos.store.domain.EmailObject;
import ca.deos.store.service.MailEndpointService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(value = "/api")
public class MailEndpointController {

    @Autowired
    MailEndpointService mailEndpointService;
//
//    @Autowired
//    EmailClient emailClient;
//
    Logger log = Logger.getLogger(MailEndpointController.class);

    @RequestMapping(value = "/email", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity mail(@RequestBody EmailObject emailObject) throws IOException, UnirestException {

        log.debug("----------------------------------------------------------------------");
        log.debug(" BEGIN SEND EMAIL");
        System.out.println("name:" + emailObject.getName());
        mailEndpointService.sendEmailWeb(emailObject);
        
        log.debug(" END PAYMENT CONFIRMATION SEND EMAIL");
        log.debug("----------------------------------------------------------------------");
        return ResponseEntity.ok().build();
    }

}
