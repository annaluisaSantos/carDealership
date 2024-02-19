package com.cardealership.dto;

import com.cardealership.enums.FuelType;
import com.cardealership.enums.State;
import com.cardealership.enums.Status;


public class VehicleDTO {

    private String licencePlateDTO;
    private VehicleBrandDTO brandDTO;
    private VehicleModelDTO modelDTO;
    private int yearDTO;
    private int numberOfSeatsDTO;
    private String tractionDTO;
    private FuelType fuelTypeDTO;
    private String colorDTO;
    private String TypeDTO;
    private State stateDTO;
    private Status statusDTO;
    private double sellingPriceDTO;
    private double purchasePriceDTO;
    private double kmsDTO;
    private int numberOfDoorsDTO;
    private int numberOfWheelsDTO;

    public VehicleDTO() { }

    public VehicleDTO(String licencePlateDTO, VehicleBrandDTO brandDTO,
                      VehicleModelDTO modelDTO, int yearDTO, int numberOfSeatsDTO,
                      String tractionDTO, FuelType fuelTypeDTO, String colorDTO,
                      State stateDTO, Status statusDTO,
                      double sellingPriceDTO, double purchasePriceDTO, double kmsDTO,
                      int numberOfDoorsDTO, int numberOfWheelsDTO) {
        this.licencePlateDTO = licencePlateDTO;
        this.brandDTO = brandDTO;
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
        this.numberOfWheelsDTO = numberOfWheelsDTO;
    }

    public String getLicencePlateDTO() {
        return licencePlateDTO;
    }

    public VehicleBrandDTO getBrandDTO() {
        return brandDTO;
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

    public String getTypeDTO() {
        return TypeDTO;
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

    public int getNumberOfWheelsDTO() {
        return numberOfWheelsDTO;
    }

    public void setLicencePlateDTO(String licencePlateDTO) {
        this.licencePlateDTO = licencePlateDTO;
    }

    public void setBrandDTO(VehicleBrandDTO brandDTO) {
        this.brandDTO = brandDTO;
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

    public void setNumberOfWheelsDTO(int numberOfWheelsDTO) {
        this.numberOfWheelsDTO = numberOfWheelsDTO;
    }
}

