package com.cardealership.dto;


public class VehicleBrandDTO {

    private String name;

    public VehicleBrandDTO( String nameDTO) {
        this.name = nameDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
