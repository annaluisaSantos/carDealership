package com.cardealership.domain;


import jakarta.persistence.*;

@Entity
public class VehicleModel {
    @Id
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private VehicleBrand vehicleBrand;

    public VehicleModel(String name, VehicleBrand vehicleBrand) {
        this.name = name;
        this.vehicleBrand = vehicleBrand;
    }

    public VehicleModel() {}



    public String getName() {
        return name;
    }

    public VehicleBrand getVehicleBrand() {
        return vehicleBrand;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleBrand(VehicleBrand vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
}
