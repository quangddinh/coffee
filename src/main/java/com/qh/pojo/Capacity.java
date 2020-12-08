package com.qh.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "capacity")
public class Capacity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int capacity;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
