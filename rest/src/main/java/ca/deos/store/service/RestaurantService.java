package ca.deos.store.service;


import ca.deos.store.entity.Restaurant;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.List;

public interface RestaurantService {

    public List<Restaurant> getRestaurants();

    public Restaurant getRestaurantById(int resId);

    public Restaurant saveOrUpdateRestaurant(Restaurant restaurant) throws UnirestException;

    public void deleteRestaurant(int resId);

    /* Profile */
    public List<Restaurant> getRestaurantByUserId(String userId) throws IOException,UnirestException;

}
