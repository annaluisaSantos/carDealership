package com.cardealership.dto;


public class VehicleModelDTO {
    private String name;

    private VehicleBrandDTO vehicleBrand;

    public VehicleModelDTO(String nameDTO, VehicleBrandDTO vehicleBrandIdDTO) {
        this.name = nameDTO;
        this.vehicleBrand = vehicleBrandIdDTO;
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
        this.vehicleBrand = vehicleBrand;
    }
}