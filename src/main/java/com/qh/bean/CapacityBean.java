package com.qh.bean;

import com.qh.pojo.Capacity;
import com.qh.service.CapacityService;
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

    public CapacityBean() {
    }

    public List<Capacity> getCapacities() {
        return capacityService.getCapacities();
    }
}
