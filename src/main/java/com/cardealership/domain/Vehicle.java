package com.cardealership.domain;

import com.cardealership.enums.FuelType;
import com.cardealership.enums.State;
import com.cardealership.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

@Entity
public class Vehicle {
    @Id
    private String licencePlate;

    @ManyToOne
    private VehicleBrand brand;
    @ManyToOne
    private VehicleModel model;
    @Column(name="ano")
    private int year;
    private int numberOfSeats;
    private String traction;
    @Enumerated(EnumType.ORDINAL)
    private FuelType fuelType;
    private String color;
    private String type;
    @Enumerated(EnumType.ORDINAL)
    private State state;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    private double sellingPrice;
    private double purchasePrice;
    private double kms;
    private int numberOfDoors;
    private int numberOfWheels;

    public Vehicle(String licencePlate, VehicleBrand brand, VehicleModel model,
                   int year, int numberOfSeats, String traction, FuelType fuelType,
                   String color, String type, State state, Status status,
                   double sellingPrice, double purchasePrice, double kms,
                   int numberOfDoors, int numberOfWheels) {
        this.licencePlate = licencePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.numberOfSeats = numberOfSeats;
        this.traction = traction;
        this.fuelType = fuelType;
        this.color = color;
        this.type = type;
        this.state = state;
        this.status = status;
        this.sellingPrice = sellingPrice;
        this.purchasePrice = purchasePrice;
        this.kms = kms;
        this.numberOfDoors = numberOfDoors;
        this.numberOfWheels = numberOfWheels;
    }

    public Vehicle() {}

    public String getLicencePlate() {
        return licencePlate;
    }

    @OneToMany
    public VehicleBrand getBrand() {
        return brand;
    }

    @OneToMany
    public VehicleModel getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getTraction() {
        return traction;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public State getState() {
        return state;
    }

    public Status getStatus() {
        return status;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getKms() {
        return kms;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setTraction(String traction) {
        this.traction = traction;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        type = type;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}

