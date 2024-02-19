package com.cardealership.domain;

import com.cardealership.enums.FuelType;
import com.cardealership.enums.State;
import com.cardealership.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

@Entity
public class Vehicle {
    @Id
    private String vin;

    private String licencePlate;

    @ManyToOne
    private VehicleModel model;
    @Column(name="ano")
    private int year;
    private int numberOfSeats;
    private String traction;
    @Enumerated(EnumType.ORDINAL)
    private FuelType fuelType;
    private String color;
    @Enumerated(EnumType.ORDINAL)
    private State state;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    private double sellingPrice;
    private double purchasePrice;
    private double kms;
    private int numberOfDoors;
     private int idBuyer;
    private int idTransaction;

    //Cosntrutor vazio

    public Vehicle() {}

    //Construtor
    public Vehicle(String vin, String licencePlate,VehicleModel model, int year, int numberOfSeats, String traction, FuelType fuelType,
                   String color, State state, Status status, double sellingPrice, double purchasePrice, double kms, int numberOfDoors, int idBuyer, int idTransaction) {
        this.vin = vin;
        this.licencePlate = licencePlate;
        this.model = model;
        this.year = year;
        this.numberOfSeats = numberOfSeats;
        this.traction = traction;
        this.fuelType = fuelType;
        this.color = color;
        this.state = state;
        this.status = status;
        this.sellingPrice = sellingPrice;
        this.purchasePrice = purchasePrice;
        this.kms = kms;
        this.numberOfDoors = numberOfDoors;
        this.idBuyer = idBuyer;
        this.idTransaction = idTransaction;
    }

    public String getVin() {
        return vin;
    }

    public String getLicencePlate() {
        return licencePlate;
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
// GETS
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

    public int getIdBuyer() {
        return idBuyer;
    }

    public int getIdTransaction() {
        return idTransaction;
    }



    // SETS
    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
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

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}

