package ca.deos.store.dao;

import ca.deos.store.entity.Hour;

import java.util.List;


public interface HourDao {

    List<Hour> getHours();

    void saveOrUpdateHour(Hour hour);

    void deleteHour(int openId);
}
