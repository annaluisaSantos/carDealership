package com.cardealership.services;

import com.cardealership.domain.*;
import com.cardealership.dto.*;
import com.cardealership.enums.State;
import com.cardealership.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StandApiImpl implements StandAPI {

    @Autowired
    private VehicleBrandsRepository vehicleBrandRepository;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private StandRepository standRepository;

    //====================================== BRANDS ===========================================================
    @Override
    public VehicleBrandDTO addBrand(VehicleBrandDTO brandDTO) {
        VehicleBrand newBrand = new VehicleBrand(brandDTO.getName());
        vehicleBrandRepository.save(newBrand);
        return new VehicleBrandDTO(newBrand.getName());
    }

    @Override
    public List<VehicleBrandDTO> listBrands() {
        return vehicleBrandRepository.findAll().stream().map(brand
                -> new VehicleBrandDTO(brand.getName())).collect(Collectors.toList());
    }

    @Override
    public VehicleBrandDTO updateBrand(String name, VehicleBrandDTO brand) {
        Optional<VehicleBrand> brandOptional = vehicleBrandRepository.findByName(name);
        if (brandOptional.isPresent()) {
            VehicleBrand vehicleBrand = brandOptional.get();
            vehicleBrand.setName(brand.getName());
            vehicleBrandRepository.save(vehicleBrand);
            return new VehicleBrandDTO(vehicleBrand.getName());
        }
        return null;
    }

    @Override
    public VehicleBrandDTO deleteBrand(String name) {
        Optional<VehicleBrand> brandToDelete = vehicleBrandRepository.findByName(name);
        if (brandToDelete.isPresent()) {
            vehicleBrandRepository.delete(brandToDelete.get());
            return new VehicleBrandDTO(brandToDelete.get().getName());
        } else {
            throw new EntityNotFoundException("Brand name not found: " + name);
        }
    }

    private VehicleBrand getVehicleBrandByName(String brandName) {
        Optional<VehicleBrand> brandOptional = vehicleBrandRepository.findByName(brandName);

        if (brandOptional.isPresent()) {
            return brandOptional.get();
        } else {
            throw new EntityNotFoundException("Brand name not found: " + brandName);
        }
    }

//====================================== MODELS ===========================================================

    private VehicleModel getVehicleModelByName(String modelName) {
        Optional<VehicleModel> modelOptional = vehicleModelRepository.findByName(modelName);
        if (modelOptional.isPresent()) {
            return modelOptional.get();
        } else {
            throw new EntityNotFoundException("Modelnot found: " + modelName);
        }
    }

    @Override
    public VehicleModelDTO addModel(VehicleModelDTO model) {
        VehicleModel newModel = new VehicleModel(model.getName(), new VehicleBrand(model.getVehicleBrandDTO().getName()));
        vehicleModelRepository.save(newModel);
        return new VehicleModelDTO(newModel.getName(), new VehicleBrandDTO(newModel.getVehicleBrand().getName()));
    }


    @Override
    public List<VehicleModelDTO> listModels() {
        List<VehicleModel> models = vehicleModelRepository.findAll();
        return models.stream().map(model ->
                new VehicleModelDTO(model.getName(), new VehicleBrandDTO(model.getVehicleBrand().getName()))
        ).collect(Collectors.toList());
    }

    @Override
    public VehicleModelDTO updateModel(String name, VehicleModelDTO modelDTO) {
        Optional<VehicleModel> existingModelOptional = vehicleModelRepository.findByName(name);

        if (existingModelOptional.isPresent()) {
            VehicleModel existingModel = existingModelOptional.get();
            existingModel.setName(modelDTO.getName());
            VehicleBrand brand = getVehicleBrandByName(modelDTO.getVehicleBrandDTO().getName());
            existingModel.setVehicleBrand(brand);
            VehicleModel savedModel = vehicleModelRepository.save(existingModel);
            return new VehicleModelDTO(savedModel.getName(), new VehicleBrandDTO(brand.getName()));
        } else {
            throw new EntityNotFoundException("Model not found: " + name);
        }
    }

    @Override
    public VehicleModelDTO deleteModel(String name) {
        Optional<VehicleModel> modelToDelete = vehicleModelRepository.findByName(name);
        if (modelToDelete.isPresent()) {
            vehicleModelRepository.delete(modelToDelete.get());
            return new VehicleModelDTO(modelToDelete.get().getName(),
                    new VehicleBrandDTO(modelToDelete.get().getVehicleBrand().getName()));
        } else {
            throw new EntityNotFoundException("Model not found: " + name);
        }
    }

//====================================== SELLERS ===========================================================

    @Override
    public List<SellerDTO> listSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream()
                .map(seller -> new SellerDTO(seller.getStandId(), seller.getName(), seller.getEmail(), seller.getPhoneNumber(), seller.getTaxNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public SellerDTO addSeller(SellerDTO sellerDTO) {
        Seller seller = new Seller(sellerDTO.getSellerIdDTO(), sellerDTO.getNameDTO(), sellerDTO.getEmailDTO(), sellerDTO.getPhoneNumberDTO(), sellerDTO.getTaxNumberDTO());
        seller = sellerRepository.save(seller);
        return new SellerDTO(seller.getStandId(), seller.getName(), seller.getEmail(), seller.getPhoneNumber(), seller.getTaxNumber());
    }

    @Override
    public SellerDTO updateSeller(long sellerId, SellerDTO sellerDTO) {
        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        if (sellerOptional.isPresent()) {
            Seller seller = sellerOptional.get();
            seller.setName(sellerDTO.getNameDTO());
            seller.setEmail(sellerDTO.getEmailDTO());
            seller.setPhoneNumber(sellerDTO.getPhoneNumberDTO());
            seller.setTaxNumber(sellerDTO.getTaxNumberDTO());
            seller = sellerRepository.save(seller);
            return new SellerDTO(seller.getStandId(), seller.getName(), seller.getEmail(), seller.getPhoneNumber(), seller.getTaxNumber());
        }
        return sellerDTO;
    }

    @Override
    public SellerDTO deleteSeller(long sellerId) {
        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        if (sellerOptional.isPresent()) {
            Seller seller = sellerOptional.get();
            sellerRepository.delete(seller);
            return new SellerDTO(seller.getStandId(), seller.getName(), seller.getEmail(), seller.getPhoneNumber(), seller.getTaxNumber());
        }
        return null;
    }

//====================================== VEHICLES ===========================================================

    @Override
    public List<VehicleDTO> listVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(vehicle ->
                new VehicleDTO(vehicle.getVin(), vehicle.getLicencePlate(),
                        new VehicleModelDTO(vehicle.getModel().getName(),
                                new VehicleBrandDTO(vehicle.getModel().getVehicleBrand().getName())),
                        vehicle.getYear(), vehicle.getNumberOfSeats(), vehicle.getTraction(),
                        vehicle.getFuelType(), vehicle.getColor(), vehicle.getState(),
                        vehicle.getStatus(), vehicle.getSellingPrice(), vehicle.getPurchasePrice(),
                        vehicle.getKms(), vehicle.getNumberOfDoors(), vehicle.getIdBuyer(), vehicle.getIdTransaction())
        ).collect(Collectors.toList());
    }

    @Override
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
        Optional<VehicleModel> modelOptional = vehicleModelRepository.findById(vehicleDTO.getModelDTO().getName());

        if (modelOptional.isPresent()) {
            VehicleModel model = modelOptional.get();

            Vehicle vehicle = new Vehicle(
                    vehicleDTO.getVin(),
                    vehicleDTO.getLicencePlateDTO(),
                    model,
                    vehicleDTO.getYearDTO(),
                    vehicleDTO.getNumberOfSeatsDTO(),
                    vehicleDTO.getTractionDTO(),
                    vehicleDTO.getFuelTypeDTO(),
                    vehicleDTO.getColorDTO(),
                    vehicleDTO.getStateDTO(),
                    vehicleDTO.getStatusDTO(),
                    vehicleDTO.getSellingPriceDTO(),
                    vehicleDTO.getPurchasePriceDTO(),
                    vehicleDTO.getKmsDTO(),
                    vehicleDTO.getNumberOfDoorsDTO(),
                    vehicleDTO.getIdBuyer(),
                    vehicleDTO.getIdTransaction()
            );

            vehicle = vehicleRepository.save(vehicle);

            return new VehicleDTO(
                    vehicle.getVin(),
                    vehicle.getLicencePlate(),
                    new VehicleModelDTO(model.getName(),
                            new VehicleBrandDTO(model.getVehicleBrand().getName())), vehicle.getYear(),
                    vehicle.getNumberOfSeats(),
                    vehicle.getTraction(),
                    vehicle.getFuelType(),
                    vehicle.getColor(),
                    vehicle.getState(),
                    vehicle.getStatus(),
                    vehicle.getSellingPrice(),
                    vehicle.getPurchasePrice(),
                    vehicle.getKms(),
                    vehicle.getNumberOfDoors(),
                    vehicle.getIdBuyer(),
                    vehicle.getIdTransaction());
        }

        return vehicleDTO;
    }

    @Override
    public VehicleDTO updateVehicle(String vin, VehicleDTO vehicleDTO) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVin(vin);

        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            Optional<VehicleModel> modelOptional = vehicleModelRepository.findById(vehicleDTO.getModelDTO().getName());

            if (modelOptional.isPresent()) {
                VehicleModel model = modelOptional.get();
                vehicle.setVin(vehicleDTO.getVin());
                vehicle.setLicencePlate(vehicleDTO.getLicencePlateDTO());
                vehicle.setModel(model);
                vehicle.setYear(vehicleDTO.getYearDTO());
                vehicle.setNumberOfSeats(vehicleDTO.getNumberOfSeatsDTO());
                vehicle.setTraction(vehicleDTO.getTractionDTO());
                vehicle.setFuelType(vehicleDTO.getFuelTypeDTO());
                vehicle.setColor(vehicleDTO.getColorDTO());
                vehicle.setState(vehicleDTO.getStateDTO());
                vehicle.setStatus(vehicleDTO.getStatusDTO());
                vehicle.setSellingPrice(vehicleDTO.getSellingPriceDTO());
                vehicle.setPurchasePrice(vehicleDTO.getPurchasePriceDTO());
                vehicle.setKms(vehicleDTO.getKmsDTO());
                vehicle.setNumberOfDoors(vehicleDTO.getNumberOfDoorsDTO());
                vehicle = vehicleRepository.save(vehicle);

                return new VehicleDTO(
                        vehicle.getVin(),
                        vehicle.getLicencePlate(),
                        new VehicleModelDTO(model.getName(),
                                new VehicleBrandDTO(model.getVehicleBrand().getName())), vehicle.getYear(),
                        vehicle.getNumberOfSeats(),
                        vehicle.getTraction(),
                        vehicle.getFuelType(),
                        vehicle.getColor(),
                        vehicle.getState(),
                        vehicle.getStatus(),
                        vehicle.getSellingPrice(),
                        vehicle.getPurchasePrice(),
                        vehicle.getKms(),
                        vehicle.getNumberOfDoors(),
                        vehicle.getIdBuyer(),
                        vehicle.getIdTransaction());
            }
        }

        return vehicleDTO;
    }

    @Override
    public VehicleDTO deleteVehicle(String vin) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVin(vin);

        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            vehicleRepository.delete(vehicle);

            return new VehicleDTO(
                    vehicle.getVin(),
                    vehicle.getLicencePlate(),
                    new VehicleModelDTO(vehicle.getModel().getName(),
                            new VehicleBrandDTO(vehicle.getModel().getVehicleBrand().getName())),
                    vehicle.getYear(),
                    vehicle.getNumberOfSeats(),
                    vehicle.getTraction(),
                    vehicle.getFuelType(),
                    vehicle.getColor(),
                    vehicle.getState(),
                    vehicle.getStatus(),
                    vehicle.getSellingPrice(),
                    vehicle.getPurchasePrice(),
                    vehicle.getKms(),
                    vehicle.getNumberOfDoors(),
                    vehicle.getIdBuyer(),
                    vehicle.getIdTransaction()
            );
        }

        return null;
    }

    @Override
    public VehicleDTO changeVehicleStatus(String vin, VehicleDTO vehicleDTO) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVin(vin);

        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            vehicle.setStatus(vehicleDTO.getStatusDTO());
            vehicle = vehicleRepository.save(vehicle);

            return new VehicleDTO(
                    vehicle.getVin(),
                    vehicle.getLicencePlate(),
                    new VehicleModelDTO(vehicle.getModel().getName(),
                            new VehicleBrandDTO(vehicle.getModel().getVehicleBrand().getName())),
                    vehicle.getYear(), vehicle.getNumberOfSeats(), vehicle.getTraction(), vehicle.getFuelType(),
                    vehicle.getColor(), vehicle.getState(), vehicle.getStatus(), vehicle.getSellingPrice(),
                    vehicle.getPurchasePrice(), vehicle.getKms(), vehicle.getNumberOfDoors(), vehicle.getIdBuyer(), vehicle.getIdTransaction()
            );
        }

        return vehicleDTO;
    }

    // Methods to get stock vehicles AND convert it to DTO.
    @Override
    public List<VehicleDTO> getStockVehicles() {
        List<VehicleDTO> stockVehicles = vehicleRepository.findByState(State.IN_STOCK).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return stockVehicles;
    }

    // Method to get all sold vehicles
    @Override
    public List<VehicleDTO> getAllVehicleSold() {
        List<VehicleDTO> soldVehicles = vehicleRepository.findByState(State.SOLD).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return soldVehicles;
    }

    @Override
    public List<VehicleDTO> findAllVehicleByBuyer(@PathVariable int idBuyer) {
        List<VehicleDTO> vehiclesBought = vehicleRepository.findAllVehicleByBuyer(idBuyer).stream().map(this::convertToDTO).collect(Collectors.toList());
        return vehiclesBought;
    }





    private VehicleDTO convertToDTO(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVin(vehicle.getVin());
        vehicleDTO.setLicencePlateDTO(vehicle.getLicencePlate());
        vehicleDTO.setModelDTO(new VehicleModelDTO(vehicle.getModel().getName(),
                new VehicleBrandDTO(vehicle.getModel().getVehicleBrand().getName())));
        vehicleDTO.setYearDTO(vehicle.getYear());
        vehicleDTO.setNumberOfSeatsDTO(vehicle.getNumberOfSeats());
        vehicleDTO.setTractionDTO(vehicle.getTraction());
        vehicleDTO.setFuelTypeDTO(vehicle.getFuelType());
        vehicleDTO.setColorDTO(vehicle.getColor());
        vehicleDTO.setStateDTO(vehicle.getState());
        vehicleDTO.setStatusDTO(vehicle.getStatus());
        vehicleDTO.setSellingPriceDTO(vehicle.getSellingPrice());
        vehicleDTO.setPurchasePriceDTO(vehicle.getPurchasePrice());
        vehicleDTO.setKmsDTO(vehicle.getKms());
        vehicleDTO.setNumberOfDoorsDTO(vehicle.getNumberOfDoors());
        vehicleDTO.setIdBuyer(vehicle.getIdBuyer());
        vehicleDTO.setIdTransaction(vehicle.getIdTransaction());
        return vehicleDTO;
    }


    //=========================================STANDS=======================================================================
    @Override
    public StandDTO addStand(StandDTO standDTO) {
        Stand newStand = new Stand(standDTO.getStandIdDTO(), standDTO.getNameDTO(), standDTO.getPhoneNumberDTO(), standDTO.getEmailDTO());
        Stand savedStand = standRepository.save(newStand);
        return new StandDTO(savedStand.getStandId(), savedStand.getName(), savedStand.getPhoneNumber(), savedStand.getEmail());
    }

    @Override
    public List<StandDTO> listStands() {
        List<Stand> stands = standRepository.findAll();
        return stands.stream().map(stand -> new StandDTO(stand.getStandId(), stand.getName(), stand.getPhoneNumber(), stand.getEmail())).collect(Collectors.toList());
    }

    @Override
    public StandDTO updateStand(long standId, StandDTO updatedStand) {
        Optional<Stand> existingStandOptional = standRepository.findById(standId);

        if (existingStandOptional.isPresent()) {
            Stand existingStand = existingStandOptional.get();
            existingStand.setName(updatedStand.getNameDTO());
            existingStand.setPhoneNumber(updatedStand.getPhoneNumberDTO());
            existingStand.setEmail(updatedStand.getEmailDTO());

            Stand savedStand = standRepository.save(existingStand);
            return new StandDTO(savedStand.getStandId(), savedStand.getName(), savedStand.getPhoneNumber(), savedStand.getEmail());
        } else {
            throw new EntityNotFoundException("Stand not found: " + standId);
        }
    }

    @Override
    public StandDTO deleteStand(long standId) {
        Optional<Stand> standToDelete = standRepository.findById(standId);

        if (standToDelete.isPresent()) {
            standRepository.delete(standToDelete.get());
            return new StandDTO(standToDelete.get().getStandId(), standToDelete.get().getName(), standToDelete.get().getPhoneNumber(), standToDelete.get().getEmail());
        } else {
            throw new EntityNotFoundException("Stand not found: " + standId);
        }
    }
}


