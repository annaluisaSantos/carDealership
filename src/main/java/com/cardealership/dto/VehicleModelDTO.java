package com.cardealership.dto;


import jakarta.persistence.*;

@Entity
public class VehicleModelDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long modelId;
    private String name;

    @OneToMany
    private VehicleBrandDTO vehicleBrand;

    public VehicleModelDTO(Long modelId, String name, VehicleBrandDTO vehicleBrand) {
        this.modelId = modelId;
        this.name = name;
        this.vehicleBrand = vehicleBrand;
    }

    public Long getModelId() {
        return modelId;
    }

    public String getName() {
        return name;
    }

    public VehicleBrandDTO getCarBrand() {
        return vehicleBrand;
    }

    public void setId(Long modelId) {
        this.modelId = modelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarBrand(VehicleBrandDTO vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
}
