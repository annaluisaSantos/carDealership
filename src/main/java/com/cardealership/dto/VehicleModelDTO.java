package com.cardealership.dto;


import jakarta.persistence.*;

@Entity
public class VehicleModelDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long modelIdSTO;
    private String nameDTO;

    @OneToMany
    private VehicleBrandDTO vehicleBrandIdDTO;

    public VehicleModelDTO(Long modelIdSTO, String nameDTO, VehicleBrandDTO vehicleBrandIdDTO) {
        this.modelIdSTO = modelIdSTO;
        this.nameDTO = nameDTO;
        this.vehicleBrandIdDTO = vehicleBrandIdDTO;
    }

    public Long getModelIdSTO() {
        return modelIdSTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public VehicleBrandDTO getVehicleBrandIdDTO() {
        return vehicleBrandIdDTO;
    }

    public void setModelIdSTO(Long modelIdSTO) {
        this.modelIdSTO = modelIdSTO;
    }

    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }

    public void setVehicleBrandIdDTO(VehicleBrandDTO vehicleBrandIdDTO) {
        this.vehicleBrandIdDTO = vehicleBrandIdDTO;
    }
}