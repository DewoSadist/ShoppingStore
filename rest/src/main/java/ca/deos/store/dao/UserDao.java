package ca.deos.store.dao;

import ca.deos.store.entity.User;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public interface UserDao {

    User getUserByLogin(String login) throws UnirestException, IOException;

    User getUser(String userId) throws UnirestException,IOException;

    void deleteUser(String userId) throws  UnirestException,IOException;
}