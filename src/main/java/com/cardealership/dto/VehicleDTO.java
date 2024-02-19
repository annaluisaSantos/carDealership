package com.cardealership.dto;

import com.cardealership.enums.FuelType;
import com.cardealership.enums.State;
import com.cardealership.enums.Status;


public class VehicleDTO {

    private String vin;

    private String licencePlateDTO;
    private VehicleModelDTO modelDTO;
    private int yearDTO;
    private int numberOfSeatsDTO;
    private String tractionDTO;
    private FuelType fuelTypeDTO;
    private String colorDTO;
    private State stateDTO;
    private Status statusDTO;
    private double sellingPriceDTO;
    private double purchasePriceDTO;
    private double kmsDTO;
    private int numberOfDoorsDTO;
    public int idBuyer;
    public int idTransaction;

    public VehicleDTO() { }

    public VehicleDTO(String vin, String licencePlateDTO, VehicleModelDTO modelDTO, int yearDTO, int numberOfSeatsDTO, String tractionDTO,
                      FuelType fuelTypeDTO, String colorDTO, State stateDTO, Status statusDTO, double sellingPriceDTO, double purchasePriceDTO, double kmsDTO,
                      int numberOfDoorsDTO, int idBuyer, int idTransaction) {
        this.vin = vin;
        this.licencePlateDTO = licencePlateDTO;
        this.modelDTO = modelDTO;
        this.yearDTO = yearDTO;
        this.numberOfSeatsDTO = numberOfSeatsDTO;
        this.tractionDTO = tractionDTO;
        this.fuelTypeDTO = fuelTypeDTO;
        this.colorDTO = colorDTO;
        this.stateDTO = stateDTO;
        this.statusDTO = statusDTO;
        this.sellingPriceDTO = sellingPriceDTO;
        this.purchasePriceDTO = purchasePriceDTO;
        this.kmsDTO = kmsDTO;
        this.numberOfDoorsDTO = numberOfDoorsDTO;
        this.idBuyer = idBuyer;
        this.idTransaction = idTransaction;
    }

    //GETS


    public String getVin() {
        return vin;
    }

    public String getLicencePlateDTO() {
        return licencePlateDTO;
    }


    public VehicleModelDTO getModelDTO() {
        return modelDTO;
    }

    public int getYearDTO() {
        return yearDTO;
    }

    public int getNumberOfSeatsDTO() {
        return numberOfSeatsDTO;
    }

    public String getTractionDTO() {
        return tractionDTO;
    }

    public FuelType getFuelTypeDTO() {
        return fuelTypeDTO;
    }

    public String getColorDTO() {
        return colorDTO;
    }


    public State getStateDTO() {
        return stateDTO;
    }

    public Status getStatusDTO() {
        return statusDTO;
    }

    public double getSellingPriceDTO() {
        return sellingPriceDTO;
    }

    public double getPurchasePriceDTO() {
        return purchasePriceDTO;
    }

    public double getKmsDTO() {
        return kmsDTO;
    }

    public int getNumberOfDoorsDTO() {
        return numberOfDoorsDTO;
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

//SETS


    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setLicencePlateDTO(String licencePlateDTO) {
        this.licencePlateDTO = licencePlateDTO;
    }



    public void setModelDTO(VehicleModelDTO modelDTO) {
        this.modelDTO = modelDTO;
    }

    public void setYearDTO(int yearDTO) {
        this.yearDTO = yearDTO;
    }

    public void setNumberOfSeatsDTO(int numberOfSeatsDTO) {
        this.numberOfSeatsDTO = numberOfSeatsDTO;
    }

    public void setTractionDTO(String tractionDTO) {
        this.tractionDTO = tractionDTO;
    }

    public void setFuelTypeDTO(FuelType fuelTypeDTO) {
        this.fuelTypeDTO = fuelTypeDTO;
    }

    public void setColorDTO(String colorDTO) {
        this.colorDTO = colorDTO;
    }


    public void setStateDTO(State stateDTO) {
        this.stateDTO = stateDTO;
    }

    public void setStatusDTO(Status statusDTO) {
        this.statusDTO = statusDTO;
    }

    public void setSellingPriceDTO(double sellingPriceDTO) {
        this.sellingPriceDTO = sellingPriceDTO;
    }

    public void setPurchasePriceDTO(double purchasePriceDTO) {
        this.purchasePriceDTO = purchasePriceDTO;
    }

    public void setKmsDTO(double kmsDTO) {
        this.kmsDTO = kmsDTO;
    }

    public void setNumberOfDoorsDTO(int numberOfDoorsDTO) {
        this.numberOfDoorsDTO = numberOfDoorsDTO;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }
}

