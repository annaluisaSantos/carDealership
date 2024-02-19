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

    //===========================================================BRANDS=================================================================================================
    @PostMapping("/addBrand")
    public ResponseEntity<VehicleBrandDTO> addBrand(@RequestBody VehicleBrandDTO brand) {
        try {
            return ResponseEntity.ok(standAPI.addBrand(brand));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listBrands")
    public ResponseEntity<List<VehicleBrandDTO>> listBrands() {
        try {
            return ResponseEntity.ok(standAPI.listBrands());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateBrand/{name}")
    public ResponseEntity<VehicleBrandDTO> updateBrand(@PathVariable String name, @RequestBody VehicleBrandDTO updatedBrand) {
        try {
            return ResponseEntity.ok(standAPI.updateBrand(name, updatedBrand));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBrand/{name}")
    public ResponseEntity<Void> deleteBrand(@PathVariable String name) {
        try {
            VehicleBrandDTO deletedBrand = standAPI.deleteBrand(name);
            if (deletedBrand != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //===================================================================== MODEL ====================================================================================

    @PostMapping("/addModel")
    public ResponseEntity<VehicleModelDTO> addModel(@RequestBody VehicleModelDTO model) {
        try {
            return ResponseEntity.ok(standAPI.addModel(model));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listModels")
    public ResponseEntity<List<VehicleModelDTO>> listModels() {
        try {
            return ResponseEntity.ok(standAPI.listModels());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateModel/{name}")
    public ResponseEntity<VehicleModelDTO> updateModel(@PathVariable String name, @RequestBody VehicleModelDTO updatedModel) {
        try {
            return ResponseEntity.ok(standAPI.updateModel(name, updatedModel));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteModel/{name}")
    public ResponseEntity<Void> deleteModel(@PathVariable String name) {
        try {
            VehicleModelDTO deletedModel = standAPI.deleteModel(name);
            if (deletedModel != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 //==============================================================SELLER =================================================================================================
    @PostMapping("/addSeller")
    public ResponseEntity<SellerDTO> addSeller (@RequestBody SellerDTO seller) {
        try {
            return ResponseEntity.ok(standAPI.addSeller(seller));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listSellers")
    public ResponseEntity<List<SellerDTO>> listSellers() {
        try {
            return ResponseEntity.ok(standAPI.listSellers());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateSeller/{sellerId}")
    public ResponseEntity<SellerDTO> updateSeller(@PathVariable long sellerId, @RequestBody SellerDTO updatedSeller) {
        try {
            return ResponseEntity.ok(standAPI.updateSeller(sellerId, updatedSeller));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSeller/{sellerId}")
    public ResponseEntity<Void> deleteSeller(@PathVariable long sellerId) {
        try {
            SellerDTO deletedSeller = standAPI.deleteSeller(sellerId);
            if (deletedSeller != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //=============================================================STAND==============================================================================================

    // Métodos para stands
    @PostMapping("/addStand")
    public ResponseEntity<StandDTO> addStand(@RequestBody StandDTO stand) {
        try {
            return ResponseEntity.ok(standAPI.addStand(stand));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listStands")
    public ResponseEntity<List<StandDTO>> listStands() {
        try {
            return ResponseEntity.ok(standAPI.listStands());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateStand/{standId}")
    public ResponseEntity<StandDTO> updateStand(@PathVariable long standId, @RequestBody StandDTO updatedStand) {
        try {
            return ResponseEntity.ok(standAPI.updateStand(standId, updatedStand));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteStand/{standId}")
    public ResponseEntity<Void> deleteStand(@PathVariable long standId) {
        try {
            StandDTO deletedStand = standAPI.deleteStand(standId);
            if (deletedStand != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }}
    // ==========================================================VEHICLE=====================================================================================================
        @GetMapping("/listVehicles")
        public ResponseEntity<List<VehicleDTO>> listVehicles() {
            try {
                return ResponseEntity.ok(standAPI.listVehicles());
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping("/addVehicle")
        public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicle) {
            try {
                return ResponseEntity.ok(standAPI.addVehicle(vehicle));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PutMapping("/updateVehicle/{vehicleId}")
        public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable long vehicleId, @RequestBody VehicleDTO updatedVehicle) {
            try {
                return ResponseEntity.ok(standAPI.updateVehicle(vehicleId, updatedVehicle));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @DeleteMapping("/deleteVehicle/{vehicleId}")
        public ResponseEntity<Void> deleteVehicle(@PathVariable long vehicleId) {
            try {
                VehicleDTO deletedVehicle = standAPI.deleteVehicle(vehicleId);
                if (deletedVehicle != null) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PutMapping("/vehicle/status/{vehicleId}")
        public ResponseEntity<VehicleDTO> changeVehicleStatus(@PathVariable long vehicleId, @RequestBody VehicleDTO updatedVehicleStatus) {
            try {
                return ResponseEntity.ok(standAPI.changeVehicleStatus(vehicleId, updatedVehicleStatus));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }