package ca.deos.store.controller;

import ca.deos.store.entity.User;
import ca.deos.store.service.UserService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User getUserLogin(@RequestBody User user) throws IOException, UnirestException {
        return userService.login(user);
    }


}
