package ca.deos.store.service.impl;


import ca.deos.store.dao.HourDao;
import ca.deos.store.entity.Hour;
import ca.deos.store.service.HourService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HourServiceImpl implements HourService {

    @Autowired
    HourDao hourDao;

    @Override
    public List<Hour> getHours() {
        return hourDao.getHours();
    }

    @Override
    public List<Hour> getRestaurantHours( int resId){
        return hourDao.getRestaurantHours(resId);
    }

    @Override
    public Hour saveOrUpdateHour(Hour hour) throws UnirestException {
        hourDao.saveOrUpdateHour(hour);
        return hour;
    }

    @Override
    public void deleteHour(int openId) {
        hourDao.deleteHour(openId);
    }
}
