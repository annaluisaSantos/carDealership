package com.cardealership.controllers;

import com.cardealership.dto.*;
import com.cardealership.services.StandAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StandManagementController {

    private StandAPI standAPI;
    @Autowired
    public StandManagementController(StandAPI standAPI) {
        this.standAPI = standAPI;
    }

    // ================================================= SELLER ===================================================
    /**
     * Get list of all sellers
     * @return List of sellers
     */
    @GetMapping("/sellers")
    public ResponseEntity<List<SellerDTO>> listSellers() {
        List<SellerDTO> sellers = standAPI.listSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    /**
     * Add a new seller
     * @param seller
     * @return seller
     */
    @PostMapping("/addSeller")
    public ResponseEntity<SellerDTO> addSeller(@RequestBody SellerDTO seller) {
        SellerDTO addedSeller = standAPI.createSeller(seller);
        return new ResponseEntity<>(addedSeller, HttpStatus.CREATED);
    }

    /**
     * Update a seller by ID
     * @param sellerId
     * @param updatedSeller
     * @return seller updated
     */
    @PutMapping("/updateSeller/{sellerId}")
    public ResponseEntity<SellerDTO> updateSeller(@PathVariable Long sellerId, @RequestBody SellerDTO updatedSeller) {
        SellerDTO seller = standAPI.updateSeller(sellerId, updatedSeller);
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    /**
     * Delete a seller by ID
     * @param sellerId
     * @return no content
     */

    @DeleteMapping("/deleteSeller/{sellerId}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long sellerId) {
        standAPI.deleteSeller(sellerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ====================================================== VEHICLES ============================================

    /**
     * Returns a list of all vehicles
     */
    @GetMapping("/listVehicles")
    public ResponseEntity<List<VehicleDTO>> listVehicles() {
        List<VehicleDTO> vehicles = standAPI.listVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    /**
     * Add a new vehicle
     */
    @PostMapping("/addVehicle")
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicle) {
        VehicleDTO addedVehicle = standAPI.addVehicle(vehicle);
        return new ResponseEntity<>(addedVehicle, HttpStatus.CREATED);
    }

    /**
     * update a vehicle by ID
     * @param vehicleId
     * @param updatedVehicle
     * @return vehicle updated
     */
    @PutMapping("/updateVehicle/{vehicleId}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable Long vehicleId, @RequestBody VehicleDTO updatedVehicle) {
        VehicleDTO vehicle = standAPI.updateVehicle(vehicleId, updatedVehicle);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    /**
     * Delete a vehicle by ID
     * @param vehicleId
     * @return no content
     */
    @DeleteMapping("/deleteVehicle/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehicleId) {
        standAPI.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // ========================================== VEHICLES MODELS =================================================

    /**
     * Get a list of all models
     * @return list of models
     */
    @GetMapping("/listModels")
    public ResponseEntity<List<VehicleModelDTO>> listModels() {
        List<VehicleModelDTO> models = standAPI.listModels();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
    /**
     * Add a new model
     */
    @PostMapping("/addModel")
    public ResponseEntity<VehicleModelDTO> addModel(@RequestBody VehicleModelDTO model) {
        VehicleModelDTO addedModel = standAPI.addModel(model);
        return new ResponseEntity<>(addedModel, HttpStatus.CREATED);
    }

    /**
     * Update a model by name
     * @param name
     * @param updatedModel
     * @return model updated
     */
    @PutMapping("/updateModel/{modelId}")
    public ResponseEntity<VehicleModelDTO> updateModel(@PathVariable String name, @RequestBody VehicleModelDTO updatedModel) {
        VehicleModelDTO model = standAPI.updateModel(name, updatedModel);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    /**
     * Delete model by name
     * @param name
     * @return no content
     */
    @DeleteMapping("/deleteModel/{modelId}")
    public ResponseEntity<VehicleModelDTO> deleteModel(@PathVariable String name) {
        standAPI.deleteModel(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // =============================================== VEHICLES BRANDS ==================================================

    /**
     * Method to add new brand
     * @param brand
     * @return brand
     */
    @PostMapping("/addBrand")
    public ResponseEntity<VehicleBrandDTO> addBrand (@RequestBody VehicleBrandDTO brand) {
        VehicleBrandDTO addedBrand = standAPI.addBrand(brand);
        return new ResponseEntity<>(addedBrand, HttpStatus.CREATED);
    }


    /**
     * Get a list of all brands
     * @return listBrands
     */
    @GetMapping("/listBrands")
    public ResponseEntity<List<VehicleBrandDTO>> listBrands() {
        List<VehicleBrandDTO> brands = standAPI.listBrands();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    /**
     * Update a brand by name
     * @param name
     * @param updatedBrand
     * @return brand updated
     */
    @PutMapping("/updateBrand/{brandId}")
    public ResponseEntity<VehicleBrandDTO> updateBrand(@PathVariable String name, @RequestBody VehicleBrandDTO updatedBrand) {
        VehicleBrandDTO brand = standAPI.updateBrand(name, updatedBrand);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    /**
     * Delete a brand by name
     * @param name
     * @return
     */
    @DeleteMapping("/deleteBrand/{brandId}")
    public ResponseEntity<Void> deleteBrand(@PathVariable String name) {
        standAPI.deleteBrand(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


//    =================================================== Stand =================================================

@PostMapping("/addStand")
public ResponseEntity<StandDTO> addStand(@RequestBody StandDTO stand) {
    StandDTO addedStand = standAPI.addStand(stand);
    return new ResponseEntity<>(addedStand, HttpStatus.CREATED);
}

@GetMapping("/listStands")
public ResponseEntity<List<StandDTO>> listStands() {
    List<StandDTO> stands = standAPI.listStands();
    return new ResponseEntity<>(stands, HttpStatus.OK);
}

@PutMapping("/updateStand/{standId}")
public ResponseEntity<StandDTO> updateStand(@PathVariable Long standId, @RequestBody StandDTO updatedStand) {
    StandDTO stand = standAPI.updateStand(standId, updatedStand);
    return new ResponseEntity<>(stand, HttpStatus.OK);
}

@DeleteMapping("/deleteStand/{standId}")
public ResponseEntity<Void> deleteStand(@PathVariable Long standId) {
    standAPI.deleteStand(standId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


}
