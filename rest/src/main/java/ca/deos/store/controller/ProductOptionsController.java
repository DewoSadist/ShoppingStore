package ca.deos.store.controller;

import ca.deos.store.entity.ProductOptions;
import ca.deos.store.service.ProductOptionsService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping(value = "/api")
public class ProductOptionsController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductOptionsService productOptionsService;


    @ResponseBody
    @RequestMapping(value = "/options", method = RequestMethod.GET)
    public List<ProductOptions> getAllProductOptions() throws IOException, UnirestException {

        return productOptionsService.getProductOptions();
    }

    @ResponseBody
    @RequestMapping(value = "/options/{optId}", method = RequestMethod.GET)
    public ProductOptions getProductOptions(@PathVariable int optId) throws IOException, UnirestException {

        return productOptionsService.getProductOptionsById(optId);
    }

    @ResponseBody
    @RequestMapping(value = "products/{prodId}/options", method = RequestMethod.GET)
    public List<ProductOptions> getProductOptionsList(@PathVariable int prodId) throws IOException, UnirestException {

        return productOptionsService.getProductOptionsListById(prodId);
    }

    @ResponseBody
    @RequestMapping(value = "/options", method = RequestMethod.POST)
    public List<ProductOptions> saveProductOptions(@RequestBody List<ProductOptions> productOptionsList) throws IOException, UnirestException {

        return productOptionsService.saveOrUpdateProductOptions(productOptionsList);
    }

    @ResponseBody
    @RequestMapping(value = "/options/{optId}", method = RequestMethod.DELETE)
    public void deleteProductOptions(@PathVariable int optId) throws IOException, UnirestException {

        productOptionsService.deleteProductOptions(optId);

    }
}
