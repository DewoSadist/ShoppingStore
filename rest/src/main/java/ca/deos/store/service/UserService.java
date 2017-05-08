package ca.deos.store.service;

import ca.deos.store.entity.User;
import com.mashape.unirest.http.exceptions.UnirestException;
import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.io.IOException;
import java.util.Map;

public interface UserService {

    public Map<String, Object> login(User user) throws UnirestException, IOException;

    public User getUser(String userId) throws UnirestException,IOException;

    public void deleteUser(String userId) throws  UnirestException,IOException;

    User saveOrUpdateUser(User user) throws  UnirestException, IOException;

    User createUser(User user) throws  UnirestException, IOException;

}
