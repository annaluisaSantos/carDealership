package com.cardealership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long StandId;
    private String name;
    private int phoneNumber;
    private String email;

    public Stand(Long standId, String name, int phoneNumber, String email) {
        StandId = standId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getStandId() {
        return StandId;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setStandId(Long standId) {
        StandId = standId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
