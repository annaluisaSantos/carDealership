package com.cardealership.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VehicleBrand {

    @Id
    private String name;

    public VehicleBrand(String name) {
        this.name = name;
    }

    public VehicleBrand() {}

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
