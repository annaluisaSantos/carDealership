package com.cardealership.services;

import com.cardealership.domain.Seller;
import com.cardealership.domain.Vehicle;
import com.cardealership.dto.SellerDTO;
import com.cardealership.dto.VehicleBrandDTO;
import com.cardealership.dto.VehicleDTO;
import com.cardealership.dto.VehicleModelDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StandAPI {

    VehicleBrandDTO addBrand(VehicleBrandDTO brand);

    VehicleModelDTO addModel(VehicleModelDTO model);

    List<SellerDTO> listSellers();

    SellerDTO createSeller(SellerDTO seller);

    SellerDTO updateSeller(long sellerId, SellerDTO seller);

    public SellerDTO deleteSeller(long sellerId);

    List<VehicleDTO> listVehicles();

    VehicleDTO addVehicle(VehicleDTO vehicle);

    VehicleDTO updateVehicle(long vehicleId, VehicleDTO vehicle);

    public VehicleDTO deleteVehicle(long vehicleId);


    VehicleDTO changeVehicleStatus(long vehicleId, VehicleDTO vehicle);
}
