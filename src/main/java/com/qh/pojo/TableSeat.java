package com.qh.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tableseat")
public class TableSeat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private String name;

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }

    @Override
    public boolean equals(Object obj) {
        TableSeat tab = (TableSeat) obj;
        return this.getId() == tab.getId();
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
