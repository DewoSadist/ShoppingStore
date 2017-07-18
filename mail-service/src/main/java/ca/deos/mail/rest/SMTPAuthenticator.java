/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.deos.mail.rest;

import javax.mail.PasswordAuthentication;

/**
 *
 * @author dewo
 */
public class SMTPAuthenticator  extends javax.mail.Authenticator {

        public SMTPAuthenticator(String SMTP_AUTH_USER, String SMTP_AUTH_PWD) {
            this.SMTP_AUTH_USER = SMTP_AUTH_USER;
            this.SMTP_AUTH_PWD = SMTP_AUTH_PWD;
        }
        
        String SMTP_AUTH_USER;
        String SMTP_AUTH_PWD;

        public String getSMTP_AUTH_USER() {
            return SMTP_AUTH_USER;
        }

        public void setSMTP_AUTH_USER(String SMTP_AUTH_USER) {
            this.SMTP_AUTH_USER = SMTP_AUTH_USER;
        }

        public String getSMTP_AUTH_PWD() {
            return SMTP_AUTH_PWD;
        }

        public void setSMTP_AUTH_PWD(String SMTP_AUTH_PWD) {
            this.SMTP_AUTH_PWD = SMTP_AUTH_PWD;
        }
        
        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
