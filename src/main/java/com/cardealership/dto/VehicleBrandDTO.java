package com.cardealership.dto;


public class VehicleBrandDTO {
    private String name;


    public VehicleBrandDTO( ) {

    }
    public VehicleBrandDTO( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
