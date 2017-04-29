package ca.deos.store.controller;

import ca.deos.store.entity.ProductOptionsItem;
import ca.deos.store.service.ProductOptionsItemService;
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
public class ProductOptionsItemController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductOptionsItemService productOptionsItemService;


    @ResponseBody
    @RequestMapping(value = "/optionsitem", method = RequestMethod.GET)
    public List<ProductOptionsItem> getAllProductOptionsItem() throws IOException, UnirestException {

        return productOptionsItemService.getProductOptionsItem();
    }

    @ResponseBody
    @RequestMapping(value = "/optionsitem/{optId}", method = RequestMethod.POST)
    public ProductOptionsItem getProductOptionsItem(@PathVariable int optId) throws IOException, UnirestException {

        return productOptionsItemService.getProductOptionsItemById(optId);
    }

    @ResponseBody
    @RequestMapping(value = "/optionsitem", method = RequestMethod.POST)
    public ProductOptionsItem saveProductOptions(@RequestBody ProductOptionsItem productOptions) throws IOException, UnirestException {

        return productOptionsItemService.saveOrUpdateProductOptionsItem(productOptions);
    }

    @ResponseBody
    @RequestMapping(value = "/optionsitem/{optId}", method = RequestMethod.DELETE)
    public void deleteProductOptionsItem(@PathVariable int optId) throws IOException, UnirestException {

        productOptionsItemService.deleteProductOptionsItem(optId);

    }
}
