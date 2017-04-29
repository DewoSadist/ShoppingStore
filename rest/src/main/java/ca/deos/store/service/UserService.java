package ca.deos.store.service;

import ca.deos.store.entity.User;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.io.IOException;

public interface UserService {

    public User login(User user) throws UnirestException, IOException;

    public User getUser(String userId) throws UnirestException,IOException;

    public void deleteUser(String userId) throws  UnirestException,IOException;





}
