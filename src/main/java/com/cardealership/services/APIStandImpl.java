package com.cardealership.services;


import com.cardealership.domain.Seller;
import com.cardealership.domain.Vehicle;
import com.cardealership.domain.VehicleBrand;
import com.cardealership.dto.SellerDTO;
import com.cardealership.dto.VehicleBrandDTO;
import com.cardealership.dto.VehicleDTO;
import com.cardealership.dto.VehicleModelDTO;
import com.cardealership.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class APIStandImpl implements StandAPI{
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    VehicleBrandsRepository vehicleBrandsRepository;
    @Autowired
    VehicleModelRepository vehicleModelRepository;


    @Override
    public VehicleBrandDTO addBrand(VehicleBrandDTO brandDTO) {
        VehicleBrand brand = new VehicleBrand();
        brand.setName(brandDTO.getNameDTO());
        brand = vehicleBrandsRepository.save(brand);
        return new VehicleBrandDTO(brand.getId(), brand.getName());
    }

    @Override
    public VehicleModelDTO addModel(VehicleModelDTO model) {
        return null;
    }

    @Override
    public List<SellerDTO> listSellers() {
        return null;
    }

    @Override
    public SellerDTO createSeller(SellerDTO seller) {
        return null;
    }

    @Override
    public SellerDTO updateSeller(long sellerId, SellerDTO seller) {
        return null;
    }

    @Override
    public ResponseEntity<Seller> deleteSeller(long sellerId) {
        return null;
    }

    @Override
    public List<VehicleDTO> listVehicles() {
        return null;
    }

    @Override
    public VehicleDTO addVehicle(VehicleDTO vehicle) {
        return null;
    }

    @Override
    public VehicleDTO updateVehicle(long vehicleId, VehicleDTO vehicle) {
        return null;
    }

    @Override
    public ResponseEntity<Vehicle> deleteVehicle(long vehicleId) {
        return null;
    }

    @Override
    public VehicleDTO changeVehicleStatus(long vehicleId, VehicleDTO vehicle) {
        return null;
    }


}
