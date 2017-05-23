package ca.deos.store.dao;

import ca.deos.store.entity.User;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.List;

public interface UserDao {

    User getUserByLogin(String login) throws UnirestException, IOException;

    User getUser(String userId) throws UnirestException,IOException;

    void deleteUser(String userId) throws  UnirestException,IOException;

    void saveOrUpdateUser(User user) throws UnirestException, IOException;

    void createUser(User user) throws UnirestException, IOException;

    List<User> getAllUsers();
}
