package ca.deos.store.controller;

import ca.deos.store.entity.User;
import ca.deos.store.service.UserService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> getUserLogin(@RequestBody User user) throws IOException, UnirestException {

        return userService.login(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) throws IOException, UnirestException {

        return userService.saveOrUpdateUser(user);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) throws IOException,UnirestException {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId)throws IOException, UnirestException {
        User user = userService.getUser(userId);
        user.setPassword(null);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getAllUsers() throws IOException, UnirestException {

        return userService.getAllUsers();
    }


}
