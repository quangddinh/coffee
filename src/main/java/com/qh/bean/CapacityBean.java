package com.qh.bean;

import com.qh.pojo.Capacity;
import com.qh.pojo.Timetable;
import com.qh.service.CapacityService;
import com.qh.service.TimetableService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
@Named(value = "capacityBean")
@SessionScoped
public class CapacityBean implements Serializable {

    private final static CapacityService capacityService = new CapacityService();
    private final static TimetableService timeService = new TimetableService();

    public CapacityBean() {
    }

    public List<Capacity> getCapacities() {
        return capacityService.getCapacities();
    }

    public List<Timetable> getTimetable() {
        return timeService.getTimetable();
    }
}
