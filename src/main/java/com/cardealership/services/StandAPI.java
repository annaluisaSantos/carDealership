package com.cardealership.services;

import com.cardealership.domain.Seller;
import com.cardealership.domain.Vehicle;
import com.cardealership.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StandAPI {

    /**
     * Methods for brands
     * @param brand
     * @return
     */
    VehicleBrandDTO addBrand(VehicleBrandDTO brand);

    List<VehicleBrandDTO> listBrands();

    VehicleBrandDTO updateBrand(String name, VehicleBrandDTO brand);

    VehicleBrandDTO deleteBrand(String name);




    /**
     * Methods for models
     * @param model
     * @return
     */
    VehicleModelDTO addModel(VehicleModelDTO model);
    List<VehicleModelDTO> listModels();

    VehicleModelDTO updateModel(String name, VehicleModelDTO model);

    VehicleModelDTO deleteModel(String name);




    /**
     * Methods for seller
     * @return
     */
    List<SellerDTO> listSellers();

    SellerDTO createSeller(SellerDTO seller);

    SellerDTO updateSeller(long sellerId, SellerDTO seller);

    public SellerDTO deleteSeller(long sellerId);




    /**
     * Methods for vehicles
     * @return
     */
    List<VehicleDTO> listVehicles();

    VehicleDTO addVehicle(VehicleDTO vehicle);

    VehicleDTO updateVehicle(long vehicleId, VehicleDTO vehicle);

    VehicleDTO deleteVehicle(long vehicleId);

    VehicleDTO changeVehicleStatus(long vehicleId, VehicleDTO vehicle);



    StandDTO addStand(StandDTO stand);
    List<StandDTO> listStands();
    StandDTO updateStand(long standId, StandDTO updatedStand);
    StandDTO deleteStand(long standId);
}
}
