package ca.deos.store.service;


import ca.deos.store.entity.Hour;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface HourService {

    public List<Hour> getHours();

    public Hour saveOrUpdateHour(Hour hour) throws UnirestException;

    public void deleteHour(int openId);

}
