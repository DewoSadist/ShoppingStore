package ca.deos.store.service.impl;

import ca.deos.store.dao.UserDao;
import ca.deos.store.entity.User;
import ca.deos.store.service.UserService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public UserServiceImpl(){
        log.info(" *** UserServiceImpl *** ");
    }

    @Override
    public Map<String, Object> login(User user) throws UnirestException, IOException {

        String login  = user.getUsername();
        String pass   = user.getPassword();
        User   dbUser = userDao.getUserByLogin(login);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(dbUser != null){
            if(passwordEncoder.matches(pass, dbUser.getPassword())){
                dbUser.setPassword(null);
                user = dbUser;
            } else {
                throw new IllegalArgumentException("One of input parameters is empty");
//                throw new UsernameNotFoundException("Invalid username or password.");
            }
        } else {
//            throw new UsernameNotFoundException("Invalid username or password.");
            throw new IllegalArgumentException("One of input parameters is empty");
        }


        // Add user data
        Map<String, Object> map = new HashMap<>();
        // @TODO We must not show sessionId param to front end
        map.put("user", user);

        return map;
    }

    @Override
    public User getUser(String userId) throws UnirestException, IOException {
        return userDao.getUser(userId);
    }

    @Override
    public void deleteUser(String userId) throws UnirestException, IOException {
        userDao.deleteUser(userId);
    }

    @Override
    public User saveOrUpdateUser(User user) throws  UnirestException, IOException {
        userDao.saveOrUpdateUser(user);
        return  user;
    }

    @Override
    public User createUser(User user) throws  UnirestException, IOException {
        userDao.createUser(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
