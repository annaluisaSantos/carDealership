package com.cardealership.domain;


import jakarta.persistence.*;

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long modelId;
    private String name;

    @OneToMany
    private VehicleBrand vehicleBrand;

    public VehicleModel(Long modelId, String name, VehicleBrand vehicleBrand) {
        this.modelId = modelId;
        this.name = name;
        this.vehicleBrand = vehicleBrand;
    }

    public VehicleModel() {}

    public Long getModelId() {
        return modelId;
    }

    public String getName() {
        return name;
    }

    public VehicleBrand getCarBrand() {
        return vehicleBrand;
    }

    public void setId(Long modelId) {
        this.modelId = modelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleBrand(VehicleBrand vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
}
