package com.cardealership.dto;


import com.cardealership.enums.FuelType;
import com.cardealership.enums.State;
import com.cardealership.enums.Status;

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