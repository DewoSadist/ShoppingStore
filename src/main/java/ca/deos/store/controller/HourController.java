package ca.deos.store.controller;

import ca.deos.store.entity.Hour;
import ca.deos.store.service.HourService;
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
public class HourController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HourService hourService;

    @ResponseBody
    @RequestMapping(value = "/restaurants/hours", method = RequestMethod.GET)
    public List<Hour> getAllHours() throws IOException, UnirestException {

        return hourService.getHours();
    }

    @ResponseBody
    @RequestMapping(value = "/restaurants/hours", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Hour saveHour(@RequestBody Hour hour) throws IOException, UnirestException {

        return hourService.saveOrUpdateHour(hour);
    }

    @ResponseBody
    @RequestMapping(value = "/restaurants/hours/{openId}", method = RequestMethod.DELETE)
    public void deleteHour(@PathVariable int openId) throws IOException, UnirestException {

        hourService.deleteHour(openId);

    }
}
