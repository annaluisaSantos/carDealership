package com.cardealership.services;

import com.cardealership.domain.*;
import com.cardealership.dto.*;
import com.cardealership.repositories.*;
import com.cardealership.services.StandAPI;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
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

    @Override
    public VehicleBrandDTO addBrand(VehicleBrandDTO brandDTO) {
        VehicleBrand brand = new VehicleBrand(brandDTO.getIdDTO(), brandDTO.getNameDTO());
        brand = vehicleBrandRepository.save(brand);
        return new VehicleBrandDTO(brand.getId(), brand.getName());
    }

    @Override
    public List<VehicleBrandDTO> listBrands() {
        List<VehicleBrand> listBrands = vehicleBrandRepository.findAll();
        return listBrands.stream().map(brand -> new VehicleBrandDTO(brand.getId(), brand.getName())).collect(Collectors.toList());
    }

    @Override
    public VehicleBrandDTO updateBrand(long BrandId, VehicleBrandDTO brand) {
        Optional<VehicleBrand> brandOptional = vehicleBrandRepository.findById(BrandId);
        if (brandOptional.isPresent()) {
            VehicleBrand vehicleBrand = brandOptional.get();
            vehicleBrand.setName(brand.getNameDTO());
            vehicleBrand = vehicleBrandRepository.save(vehicleBrand);
            return new VehicleBrandDTO(vehicleBrand.getId(), vehicleBrand.getName());
        }
        return null;
    }

    @Override
    public VehicleBrandDTO deleteBrand(long BrandId) {
        Optional<VehicleBrand> brandOptional = vehicleBrandRepository.findById(BrandId);
        if (brandOptional.isPresent()) {
            vehicleBrandRepository.delete(brandOptional.get());
            return new VehicleBrandDTO(brandOptional.get().getId(), brandOptional.get().getName());
        }
        return null;
    }

    @Override
    public VehicleModelDTO addModel(VehicleModelDTO modelDTO) {
        Optional<VehicleBrand> brandOptional = vehicleBrandRepository.findById(modelDTO.getVehicleBrandIdDTO().getIdDTO());
        if (brandOptional.isPresent()) {
            VehicleModel model = new VehicleModel(modelDTO.getModelIdSTO(), modelDTO.getNameDTO(), brandOptional.get());
            model = vehicleModelRepository.save(model);
            return new VehicleModelDTO(model.getModelId(), model.getName(), new VehicleBrandDTO(model.getCarBrand().getId(), model.getCarBrand().getName()));
        }
        return null;
    }

    @Override
    public List<VehicleModelDTO> listModels() {
        List<VehicleModel> listModels = vehicleModelRepository.findAll();
        return listModels.stream()
                .map(model -> new VehicleModelDTO(model.getModelId(), model.getName(), mapToDTO(model.getCarBrand())))
                .collect(Collectors.toList());
    }
    private VehicleBrandDTO mapToDTO(VehicleBrand vehicleBrand) {
        return new VehicleBrandDTO(vehicleBrand.getId(), vehicleBrand.getName());
    }


    @Override
    public VehicleModelDTO updateModel(long modelId, VehicleModelDTO updatedModel) {
        Optional<VehicleModel> modelOptional = vehicleModelRepository.findById(modelId);

        if (modelOptional.isPresent()) {
            VehicleModel model = modelOptional.get();
            model.setName(updatedModel.getNameDTO());
            VehicleModel savedModel = vehicleModelRepository.save(model);
        } else {
            throw new EntityNotFoundException("Model not found " + modelId);
        }
        return null;
    }

    @Override
    public VehicleModelDTO deleteModel(long modelId) {
        Optional<VehicleModel> modelOptional = vehicleModelRepository.findById(modelId);
        if (modelOptional.isPresent()) {
            vehicleModelRepository.delete(modelOptional.get());
            return new VehicleModelDTO(modelOptional.get().getModelId(), modelOptional.get().getName(), new VehicleBrandDTO(modelOptional.get().getCarBrand().getId(), modelOptional.get().getCarBrand().getName()));
        } else {
            throw new EntityNotFoundException("Model not found: " + modelId);
        }
    }


    @Override
    public List<SellerDTO> listSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream()
                .map(seller -> new SellerDTO(seller.getStandId(), seller.getName(), seller.getEmail(), seller.getPhoneNumber(), seller.getTaxNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public SellerDTO createSeller(SellerDTO sellerDTO) {
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
        return null;
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

    @Override
    public List<VehicleDTO> listVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(vehicle -> new VehicleDTO(
                        vehicle.getLicencePlate(),
                        new VehicleBrandDTO(vehicle.getBrand().getId(), vehicle.getBrand().getName()),
                        new VehicleModelDTO(vehicle.getModel().getModelId(), vehicle.getModel().getName(), new VehicleBrandDTO(vehicle.getModel().getCarBrand().getId(), vehicle.getModel().getCarBrand().getName())),
                        vehicle.getYear(),
                        vehicle.getNumberOfSeats(),
                        vehicle.getTraction(),
                        vehicle.getFuelType(),
                        vehicle.getColor(),
                        vehicle.getType(),
                        vehicle.getState(),
                        vehicle.getStatus(),
                        vehicle.getSellingPrice(),
                        vehicle.getPurchasePrice(),
                        vehicle.getKms(),
                        vehicle.getNumberOfDoors(),
                        vehicle.getNumberOfWheels()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
        Optional<VehicleBrand> brandOptional = vehicleBrandRepository.findById(vehicleDTO.getBrandDTO().getIdDTO());
        Optional<VehicleModel> modelOptional = vehicleModelRepository.findById(vehicleDTO.getModelDTO().getModelIdSTO());

        if (brandOptional.isPresent() && modelOptional.isPresent()) {
            VehicleBrand brand = brandOptional.get();
            VehicleModel model = modelOptional.get();

            Vehicle vehicle = new Vehicle(
                    vehicleDTO.getLicencePlateDTO(),
                    brand,
                    model,
                    vehicleDTO.getYearDTO(),
                    vehicleDTO.getNumberOfSeatsDTO(),
                    vehicleDTO.getTractionDTO(),
                    vehicleDTO.getFuelTypeDTO(),
                    vehicleDTO.getColorDTO(),
                    vehicleDTO.getTypeDTO(),
                    vehicleDTO.getStateDTO(),
                    vehicleDTO.getStatusDTO(),
                    vehicleDTO.getSellingPriceDTO(),
                    vehicleDTO.getPurchasePriceDTO(),
                    vehicleDTO.getKmsDTO(),
                    vehicleDTO.getNumberOfDoorsDTO(),
                    vehicleDTO.getNumberOfWheelsDTO()
            );

            vehicle = vehicleRepository.save(vehicle);

            return new VehicleDTO(
                    vehicle.getLicencePlate(),
                    new VehicleBrandDTO(vehicle.getBrand().getId(), vehicle.getBrand().getName()),
                    new VehicleModelDTO(vehicle.getModel().getModelId(), vehicle.getModel().getName(), new VehicleBrandDTO(vehicle.getModel().getCarBrand().getId(), vehicle.getModel().getCarBrand().getName())),
                    vehicle.getYear(),
                    vehicle.getNumberOfSeats(),
                    vehicle.getTraction(),
                    vehicle.getFuelType(),
                    vehicle.getColor(),
                    vehicle.getType(),
                    vehicle.getState(),
                    vehicle.getStatus(),
                    vehicle.getSellingPrice(),
                    vehicle.getPurchasePrice(),
                    vehicle.getKms(),
                    vehicle.getNumberOfDoors(),
                    vehicle.getNumberOfWheels()
            );
        }

        return null;
    }

    @Override
    public VehicleDTO updateVehicle(long vehicleId, VehicleDTO vehicleDTO) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            Optional<VehicleBrand> brandOptional = vehicleBrandRepository.findById(vehicleDTO.getBrandDTO().getIdDTO());
            Optional<VehicleModel> modelOptional = vehicleModelRepository.findById(vehicleDTO.getModelDTO().getModelIdSTO());
            if (brandOptional.isPresent() && modelOptional.isPresent()) {
                VehicleBrand brand = brandOptional.get();
                VehicleModel model = modelOptional.get();
                vehicle.setLicencePlate(vehicleDTO.getLicencePlateDTO());
                vehicle.setBrand(brand);
                vehicle.setModel(model);
                vehicle.setYear(vehicleDTO.getYearDTO());
                vehicle.setNumberOfSeats(vehicleDTO.getNumberOfSeatsDTO());
                vehicle.setTraction(vehicleDTO.getTractionDTO());
                vehicle.setFuelType(vehicleDTO.getFuelTypeDTO());
                vehicle.setColor(vehicleDTO.getColorDTO());
                vehicle.setType(vehicleDTO.getTypeDTO());
                vehicle.setState(vehicleDTO.getStateDTO());
                vehicle.setStatus(vehicleDTO.getStatusDTO());
                vehicle.setSellingPrice(vehicleDTO.getSellingPriceDTO());
                vehicle.setPurchasePrice(vehicleDTO.getPurchasePriceDTO());
                vehicle.setKms(vehicleDTO.getKmsDTO());
                vehicle.setNumberOfDoors(vehicleDTO.getNumberOfDoorsDTO());
                vehicle.setNumberOfWheels(vehicleDTO.getNumberOfWheelsDTO());
                vehicle = vehicleRepository.save(vehicle);
                return new VehicleDTO(
                        vehicle.getLicencePlate(),
                        new VehicleBrandDTO(vehicle.getBrand().getId(), vehicle.getBrand().getName()),
                        new VehicleModelDTO(vehicle.getModel().getModelId(), vehicle.getModel().getName(), new VehicleBrandDTO(vehicle.getModel().getCarBrand().getId(), vehicle.getModel().getCarBrand().getName())),
                        vehicle.getYear(),
                        vehicle.getNumberOfSeats(),
                        vehicle.getTraction(),
                        vehicle.getFuelType(),
                        vehicle.getColor(),
                        vehicle.getType(),
                        vehicle.getState(),
                        vehicle.getStatus(),
                        vehicle.getSellingPrice(),
                        vehicle.getPurchasePrice(),
                        vehicle.getKms(),
                        vehicle.getNumberOfDoors(),
                        vehicle.getNumberOfWheels()
                );
            }
        }
        return null;
    }

    @Override
    public VehicleDTO deleteVehicle(long vehicleId) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            vehicleRepository.delete(vehicle);
            return new VehicleDTO(
                    vehicle.getLicencePlate(),
                    new VehicleBrandDTO(vehicle.getBrand().getId(), vehicle.getBrand().getName()),
                    new VehicleModelDTO(vehicle.getModel().getModelId(), vehicle.getModel().getName(), new VehicleBrandDTO(vehicle.getModel().getCarBrand().getId(), vehicle.getModel().getCarBrand().getName())),
                    vehicle.getYear(),
                    vehicle.getNumberOfSeats(),
                    vehicle.getTraction(),
                    vehicle.getFuelType(),
                    vehicle.getColor(),
                    vehicle.getType(),
                    vehicle.getState(),
                    vehicle.getStatus(),
                    vehicle.getSellingPrice(),
                    vehicle.getPurchasePrice(),
                    vehicle.getKms(),
                    vehicle.getNumberOfDoors(),
                    vehicle.getNumberOfWheels()
            );
        }
        return null;
    }

    @Override
    public VehicleDTO changeVehicleStatus(long vehicleId, VehicleDTO vehicleDTO) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            vehicle.setStatus(vehicleDTO.getStatusDTO());
            vehicle = vehicleRepository.save(vehicle);
            return new VehicleDTO(
                    vehicle.getLicencePlate(),
                    new VehicleBrandDTO(vehicle.getBrand().getId(), vehicle.getBrand().getName()),
                    new VehicleModelDTO(vehicle.getModel().getModelId(), vehicle.getModel().getName(), new VehicleBrandDTO(vehicle.getModel().getCarBrand().getId(), vehicle.getModel().getCarBrand().getName())),
                    vehicle.getYear(),
                    vehicle.getNumberOfSeats(),
                    vehicle.getTraction(),
                    vehicle.getFuelType(),
                    vehicle.getColor(),
                    vehicle.getType(),
                    vehicle.getState(),
                    vehicle.getStatus(),
                    vehicle.getSellingPrice(),
                    vehicle.getPurchasePrice(),
                    vehicle.getKms(),
                    vehicle.getNumberOfDoors(),
                    vehicle.getNumberOfWheels()
            );
        }
        return null;
    }
}
