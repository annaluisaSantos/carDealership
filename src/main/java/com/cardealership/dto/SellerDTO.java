package com.cardealership.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class SellerDTO {

    private Long sellerIdDTO;
    private String nameDTO;
    private String emailDTO;
    private int phoneNumberDTO;
    private int taxNumberDTO;

    public SellerDTO(Long sellerIdDTO, String nameDTO, String emailDTO, int phoneNumberDTO, int taxNumberDTO) {
        this.sellerIdDTO = sellerIdDTO;
        this.nameDTO = nameDTO;
        this.emailDTO = emailDTO;
        this.phoneNumberDTO = phoneNumberDTO;
        this.taxNumberDTO = taxNumberDTO;
    }

    public Long getSellerIdDTO() {
        return sellerIdDTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public int getPhoneNumberDTO() {
        return phoneNumberDTO;
    }


    public int getTaxNumberDTO() {
        return taxNumberDTO;
    }

    public void setSellerIdDTO(Long sellerIdDTO) {
        sellerIdDTO = sellerIdDTO;
    }

    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }

    public void setPhoneNumberDTO(int phoneNumberDTO) {
        this.phoneNumberDTO = phoneNumberDTO;
    }

    public void setTaxNumberDTO(int taxNumberDTO) {
        this.taxNumberDTO = taxNumberDTO;
    }
}
