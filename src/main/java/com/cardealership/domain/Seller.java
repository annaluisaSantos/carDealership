package com.cardealership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Seller {
    @Id
    @GeneratedValue
    private Long StandId;

}
