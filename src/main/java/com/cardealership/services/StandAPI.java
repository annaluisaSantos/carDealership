package com.cardealership.services;

import com.cardealership.domain.Seller;
import com.cardealership.domain.Vehicle;
import com.cardealership.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

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

    SellerDTO addSeller(SellerDTO seller);

    SellerDTO updateSeller(long sellerId, SellerDTO seller);

    public SellerDTO deleteSeller(long sellerId);




    /**
     * Methods for vehicles
     * @return
     */
    List<VehicleDTO> listVehicles();

    VehicleDTO addVehicle(VehicleDTO vehicle);

    VehicleDTO updateVehicle(String Vin, VehicleDTO vehicle);

    VehicleDTO deleteVehicle(String vin);

    VehicleDTO changeVehicleStatus(String vin, VehicleDTO vehicle);

    List<VehicleDTO> getStockVehicles();

    List<VehicleDTO> getAllVehicleSold();

    List<VehicleDTO> findAllVehicleByBuyer(@PathVariable int idBuyer);

    /**
     * Methods for stand
     * @param stand
     * @return
     */
    StandDTO addStand(StandDTO stand);
    List<StandDTO> listStands();
    StandDTO updateStand(long standId, StandDTO updatedStand);
    StandDTO deleteStand(long standId);
}

