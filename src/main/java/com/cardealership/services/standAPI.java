package com.cardealership.services;

import com.cardealership.dto.SellerDTO;
import com.cardealership.dto.VehicleBrandDTO;
import com.cardealership.dto.VehicleDTO;
import com.cardealership.dto.VehicleModelDTO;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface standAPI {

    public VehicleBrandDTO addBrand(VehicleBrandDTO brand);
    public VehicleModelDTO addModel(VehicleModelDTO model);
    public List<SellerDTO> listSellers();
    SellerDTO createSeller(SellerDTO seller);
    SellerDTO updateSeller(long sellerId, SellerDTO seller);
    SellerDTO deleteSeller(long sellerId);
    List<VehicleDTO> listVehicles();
    VehicleDTO addVehicle(VehicleDTO vehicle);
    VehicleDTO updateVehicle(long vehicleId, VehicleDTO vehicle);
    VehicleDTO deleteVehicle(long vehicleId);
    VehicleDTO changeVehicleStatus(long vehicleId, VehicleDTO vehicle);


}
