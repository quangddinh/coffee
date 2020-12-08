package com.qh.bean;

import com.qh.pojo.Capacity;
import com.qh.pojo.Timetable;
import com.qh.service.CapacityService;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@Named(value = "bookingBean")
@RequestScoped
public class BookingBean {

    public Timetable getTime() {
        return time;
    }

    public void setTime(Timetable time) {
        this.time = time;
    }

    public BookingBean() {
    }

    private int bookingId;
    private String name;
    private String phone;
    private Timetable time;
    private String description;
    private Capacity capacity;

    private final static CapacityService capService = new CapacityService();

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

}
