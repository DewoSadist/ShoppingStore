package ca.deos.store.controller;

import ca.deos.store.entity.Restaurant;
import ca.deos.store.service.RestaurantService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping(value = "/api")
public class RestaurantController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestaurantService restaurantService;

    @ResponseBody
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants() throws IOException, UnirestException {

        return restaurantService.getRestaurants();
    }

    @ResponseBody
    @RequestMapping(value = "/restaurants", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) throws IOException, UnirestException {

        return restaurantService.saveOrUpdateRestaurant(restaurant);
    }

    @ResponseBody
    @RequestMapping(value = "/restaurants/{resId}", method = RequestMethod.DELETE)
    public void deleteRestaurant(@PathVariable int resId) throws IOException, UnirestException {

        restaurantService.deleteRestaurant(resId);

    }
}
