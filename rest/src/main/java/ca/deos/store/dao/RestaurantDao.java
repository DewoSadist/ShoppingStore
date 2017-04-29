package ca.deos.store.dao;

import ca.deos.store.entity.Restaurant;

import java.util.List;

public interface RestaurantDao {

    public List<Restaurant> getRestaurants();

    public Restaurant getRestaurantById(int resId);

    public void saveOrUpdateRestaurant(Restaurant restaurant);

    public void deleteRestaurant(int resId);
}
