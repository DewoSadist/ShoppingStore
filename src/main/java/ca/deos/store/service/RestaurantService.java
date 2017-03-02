package ca.deos.store.service;


import ca.deos.store.entity.Restaurant;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface RestaurantService {

    public List<Restaurant> getRestaurants();

    public Restaurant saveOrUpdateRestaurant(Restaurant restaurant) throws UnirestException;

    public void deleteRestaurant(int resId);

}
