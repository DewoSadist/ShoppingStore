package ca.deos.store.dao;

import ca.deos.store.entity.Hour;

import java.util.List;


public interface HourDao {

    List<Hour> getHours();

    List<Hour> getRestaurantHours(int resId);

    void saveOrUpdateHour(Hour hour);

    void deleteHour(int openId);
}
