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
    @RequestMapping(value = "/options/{optId}", method = RequestMethod.POST)
    public ProductOptions getProductOptions(@PathVariable int optId) throws IOException, UnirestException {

        return productOptionsService.getProductOptionsById(optId);
    }

    @ResponseBody
    @RequestMapping(value = "/options", method = RequestMethod.POST)
    public ProductOptions saveProductOptions(@RequestBody ProductOptions productOptions) throws IOException, UnirestException {

        return productOptionsService.saveOrUpdateProductOptions(productOptions);
    }

    @ResponseBody
    @RequestMapping(value = "/options/{optId}", method = RequestMethod.DELETE)
    public void deleteProductOptions(@PathVariable int optId) throws IOException, UnirestException {

        productOptionsService.deleteProductOptions(optId);

    }
}
