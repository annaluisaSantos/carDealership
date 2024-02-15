package com.cardealership.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VehicleBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long brandId;
    private String name;

    public VehicleBrand(Long brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public VehicleBrand() {}

    public Long getId() {
        return brandId;
    }

    public String getName() {
        return name;
    }

    public void setId(Long brandId) {
        this.brandId = brandId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
