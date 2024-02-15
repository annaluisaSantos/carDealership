package com.cardealership.services;

import com.cardealership.dto.SellerDTO;
import com.cardealership.dto.VehicleBrandDTO;
import com.cardealership.dto.VehicleDTO;
import com.cardealership.dto.VehicleModelDTO;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface standAPI {
    //Metodos aka buyVehicles, createvehicle...

    ResponseEntity<VehicleBrandDTO> createBrand(VehicleBrandDTO brand);
    ResponseEntity<VehicleModelDTO> createModel(VehicleModelDTO model);


    //Sellers
    ResponseEntity<List<SellerDTO>> listSellers();
    ResponseEntity<SellerDTO> addSeller(SellerDTO sellerDTO);
    ResponseEntity<SellerDTO> updateSeller(SellerDTO sellerDTO, Long sellerId);
    ResponseEntity<SellerDTO> deleteSeller(Long sellerId);


    //Vehicles
    ResponseEntity<List<VehicleDTO>> getAllVehicles();
    ResponseEntity<VehicleDTO> getVehicleById(Long id);
    ResponseEntity<>




}
