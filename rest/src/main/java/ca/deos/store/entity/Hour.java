package ca.deos.store.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="open_hour")
public class  Hour {
    @Id
    @Column(name = "open_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int open_id;

    @Column(name = "day")
    String day;

    @Column(name = "open_hour")
    Time open_hour;

    @Column(name = "close_hour")
    Time close_hour;

    @ManyToOne
    @JoinColumn(name = "res_id")
    Restaurant restaurant;

    public int getOpen_id() {
        return open_id;
    }

    public void setOpen_id(int open_id) {
        this.open_id = open_id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getOpen_hour() {
        return open_hour;
    }

    public void setOpen_hour(Time open_hour) {
        this.open_hour = open_hour;
    }

    public Time getClose_hour() {
        return close_hour;
    }

    public void setClose_hour(Time close_hour) {
        this.close_hour = close_hour;
    }

    @Override
    public String toString() {
        return "Hour{" +
                "open_id=" + open_id +
                ", day='" + day + '\'' +
                ", open_hour=" + open_hour +
                ", close_hour=" + close_hour +
                '}';
    }
}
