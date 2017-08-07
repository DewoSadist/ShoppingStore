package ca.deos.store.service.impl;


import ca.deos.store.dao.RestaurantDao;
import ca.deos.store.entity.Restaurant;
import ca.deos.store.service.RestaurantService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantDao restaurantDao;

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantDao.getRestaurants();
    }
    @Override
    public Restaurant getRestaurantById(int resId){
        Restaurant restaurant = restaurantDao.getRestaurantById(resId);
        return restaurant;
    }

    @Override
    public Restaurant saveOrUpdateRestaurant(Restaurant restaurant) {

        restaurantDao.saveOrUpdateRestaurant(restaurant);
        return restaurant;
    }

    @Override
    public void deleteRestaurant(int resId) { restaurantDao.deleteRestaurant(resId);

    }
    /* Profile */
    public List<Restaurant> getRestaurantByUserId(String userId) throws IOException,UnirestException{
        return restaurantDao.getRestaurantByUserId(userId);
    }
}
