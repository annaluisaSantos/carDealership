package com.cardealership.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VehicleBrandDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long brandIdDTO;
    private String nameDTO;

    public VehicleBrandDTO(Long brandIdDTO, String nameDTO) {
        this.brandIdDTO = brandIdDTO;
        this.nameDTO = nameDTO;
    }

    public Long getIdDTO() {
        return brandIdDTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public void setIdDTO(Long brandIdDTO) {
        this.brandIdDTO = brandIdDTO;
    }

    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }
}
