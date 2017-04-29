package ca.deos.store.service.impl;

import ca.deos.store.dao.UserDao;
import ca.deos.store.entity.User;
import ca.deos.store.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDao userDao;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public UserServiceImpl(){
        log.info(" *** UserServiceImpl *** ");
    }

    @Override
    public User login(User user) throws UnirestException, IOException {
        String login = user.getUsername();
        String pass = user.getPassword();
        User dbUser = userDao.getUserByLogin(login);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(dbUser != null){
            if(passwordEncoder.matches(pass, dbUser.getPassword())){
                dbUser.setPassword(null);
                user = dbUser;
            } else {
                throw new UsernameNotFoundException("Invalid username or password.");
            }
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return user;
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
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        return null;
    }
}
