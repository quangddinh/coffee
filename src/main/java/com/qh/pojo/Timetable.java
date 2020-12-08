package com.qh.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String time;
    private String description;

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }

    @Override
    public boolean equals(Object obj) {
        Capacity cap = (Capacity) obj;
        return this.getId() == cap.getId();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.getId();
        return hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
