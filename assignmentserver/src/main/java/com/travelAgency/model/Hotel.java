package com.travelAgency.model;
import java.io.Serializable;

public class Hotel implements Serializable{
    private static final long serialVersionUID = -5577579081118070434L;

    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
