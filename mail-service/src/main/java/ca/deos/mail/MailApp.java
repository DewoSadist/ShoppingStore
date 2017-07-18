/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.deos.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author dewo
 */
@SpringBootApplication
@ComponentScan({
    "ca.deos.mail.service",
    "ca.deos.mail.rest"
})
public class MailApp {

    public static void main(String[] args) {
        SpringApplication.run(MailApp.class, args);
    }
}
