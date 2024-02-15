package com.cardealership.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SellerDTO {
    @Id
    @GeneratedValue
    private Long sellerIdDTO;
    private String nameDTO;
    private String emailDTO;
    private int phoneNumberDTO;

    public SellerDTO(Long sellerIdDTO, String nameDTO, String emailDTO, int phoneNumberDTO) {
        this.sellerIdDTO = sellerIdDTO;
        this.nameDTO = nameDTO;
        this.emailDTO = emailDTO;
        this.phoneNumberDTO = phoneNumberDTO;
    }

    public Long getsellerIdDTO() {
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

    public void setsellerIdDTO(Long sellerIdDTO) {
        sellerIdDTO = sellerIdDTO;
    }

    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumberDTO = phoneNumberDTO;
    }
}
