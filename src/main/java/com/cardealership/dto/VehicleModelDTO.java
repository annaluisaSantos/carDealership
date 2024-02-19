package com.cardealership.dto;


public class VehicleModelDTO {
    private String name;

    private VehicleBrandDTO vehicleBrand;

    public VehicleModelDTO() { }

    public VehicleModelDTO(String name, VehicleBrandDTO vehicleBrand) {
        this.name = name;
        this.vehicleBrand = vehicleBrand;
    }



    public String getName() {
        return name;
    }

    public VehicleBrandDTO getVehicleBrandDTO() {
        return vehicleBrand;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleBrandDTO(VehicleBrandDTO vehicleBrandDTO) {
        this.vehicleBrand = vehicleBrandDTO;
    }

}