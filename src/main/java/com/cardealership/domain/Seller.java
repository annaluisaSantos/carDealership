package com.cardealership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Seller {
    @Id
    @GeneratedValue
    private Long StandId;
    private String name;
    private String email;
    private int phoneNumber;
    private int taxNumber;

    public Seller(Long standId, String name, String email, int phoneNumber, int taxNumber) {
        this.StandId = standId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.taxNumber = taxNumber;
    }

    public Seller() { }

    public Long getStandId() {
        return StandId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public void setStandId(Long standId) {
        StandId = standId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

}
