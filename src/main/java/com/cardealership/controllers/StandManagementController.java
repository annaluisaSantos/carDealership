package com.cardealership.controllers;

import com.cardealership.dto.*;
import com.cardealership.services.StandAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
            VehicleBrandDTO addedBrand = standAPI.addBrand(brand);
            addedBrand.add(linkTo(methodOn(StandManagementController.class).listBrands()).withRel("listBrands"));
            addedBrand.add(linkTo(methodOn(StandManagementController.class).updateBrand(addedBrand.getName(), brand)).withRel("updateBrand"));
            addedBrand.add(linkTo(methodOn(StandManagementController.class).deleteBrand(addedBrand.getName())).withRel("deleteBrand"));
            addedBrand.add(linkTo(methodOn(StandManagementController.class).findByBrand(addedBrand.getName())).withRel("findByBrand"));
            return new ResponseEntity<>(addedBrand, HttpStatus.OK);
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

    @Transactional
    @PostMapping("/addModel")
    public ResponseEntity<VehicleModelDTO> addModel(@RequestBody VehicleModelDTO model) {
        try {
            VehicleModelDTO addedModel = standAPI.addModel(model);
            addedModel.add(linkTo(methodOn(StandManagementController.class).listModels()).withRel("listModels"));
            addedModel.add(linkTo(methodOn(StandManagementController.class).updateModel(addedModel.getName(), model)).withRel("updateModel"));
            addedModel.add(linkTo(methodOn(StandManagementController.class).deleteModel(addedModel.getName())).withRel("deleteModel"));
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

    @Transactional
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
    public ResponseEntity<SellerDTO> addSeller(@RequestBody SellerDTO seller) {
        try {
            SellerDTO addedSeller = standAPI.addSeller(seller);
            addedSeller.add(linkTo(methodOn(StandManagementController.class).listSellers()).withRel("listSellers"));
            addedSeller.add(linkTo(methodOn(StandManagementController.class).updateSeller(addedSeller.getSellerIdDTO(), seller)).withRel("updateSeller"));
            addedSeller.add(linkTo(methodOn(StandManagementController.class).deleteSeller(addedSeller.getSellerIdDTO())).withRel("deleteSeller"));
            return new ResponseEntity<>(addedSeller, HttpStatus.OK);
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
            StandDTO addedStand = standAPI.addStand(stand);
            addedStand.add(linkTo(methodOn(StandManagementController.class).listStands()).withRel("listStands"));
            addedStand.add(linkTo(methodOn(StandManagementController.class).updateStand(addedStand.getStandIdDTO(), stand)).withRel("updateStand"));
            addedStand.add(linkTo(methodOn(StandManagementController.class).deleteStand(addedStand.getStandIdDTO())).withRel("deleteStand"));
            return new ResponseEntity<>(addedStand, HttpStatus.OK);
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
        }
    }

    // ==========================================================VEHICLE=====================================================================================================
    @GetMapping("/listVehicles")
    public ResponseEntity<List<VehicleDTO>> listVehicles() {
        try {
            return ResponseEntity.ok(standAPI.listVehicles());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @PostMapping("/addVehicle")
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicle) {
        try {
            VehicleDTO addedVehicle = standAPI.addVehicle(vehicle);
            addedVehicle.add(linkTo(methodOn(StandManagementController.class).listVehicles()).withRel("listVehicles"));
            addedVehicle.add(linkTo(methodOn(StandManagementController.class).updateVehicle(addedVehicle.getVin(), vehicle)).withRel("updateVehicle"));
            addedVehicle.add(linkTo(methodOn(StandManagementController.class).deleteVehicle(addedVehicle.getVin())).withRel("deleteVehicle"));
            addedVehicle.add(linkTo(methodOn(StandManagementController.class).changeVehicleStatus(addedVehicle.getVin(), vehicle)).withRel("changeVehicleStatus"));
            addedVehicle.add(linkTo(methodOn(StandManagementController.class).getSoldVehicles(addedVehicle.getIdBuyer(), addedVehicle.getIdTransaction())).withRel("getSoldVehicles"));
            addedVehicle.add(linkTo(methodOn(StandManagementController.class).getStockVehicles()).withRel("getStockVehicles"));
            addedVehicle.add(linkTo(methodOn(StandManagementController.class).findAllVehicleByBuyer(addedVehicle.getIdBuyer())).withRel("findAllVehicleByBuyer"));
            addedVehicle.add(linkTo(methodOn(StandManagementController.class).findByBrand(addedVehicle.getModelDTO().getVehicleBrandDTO().getName())).withRel("findByBrand"));
            return new ResponseEntity<>(addedVehicle, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @PutMapping("/updateVehicle/{vin}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable String vin, @RequestBody VehicleDTO updatedVehicle) {
        try {
            return ResponseEntity.ok(standAPI.updateVehicle(vin, updatedVehicle));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteVehicle/{vin}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String vin) {
        try {
            VehicleDTO deletedVehicle = standAPI.deleteVehicle(vin);
            if (deletedVehicle != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @PutMapping("/vehicle/status/{vin}")
    public ResponseEntity<VehicleDTO> changeVehicleStatus(@PathVariable String vin, @RequestBody VehicleDTO updatedVehicleStatus) {
        try {
            return ResponseEntity.ok(standAPI.changeVehicleStatus(vin, updatedVehicleStatus));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/stock")
    public ResponseEntity<List<VehicleDTO>> getStockVehicles() {
        List<VehicleDTO> stockVehicles = standAPI.getStockVehicles();
        try {
            return new ResponseEntity<>(stockVehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/soldVehicles")
    public ResponseEntity<List<VehicleDTO>> getSoldVehicles(@RequestParam("buyerId") int buyerId,
                                                            @RequestParam("transactionId") int transactionId) {
        List<VehicleDTO> soldVehicles = standAPI.getAllVehicleSold(buyerId, transactionId);
        for (VehicleDTO vehicleDTO : soldVehicles) {
            vehicleDTO.setIdBuyer(buyerId);
            vehicleDTO.setIdTransaction(transactionId);
        }
        return new ResponseEntity<>(soldVehicles, HttpStatus.OK);
    }

    @GetMapping("/soldByBuyer/{buyerId}")
    public ResponseEntity<List<VehicleDTO>> findAllVehicleByBuyer(@PathVariable("buyerId") int buyerId) {
        List<VehicleDTO> boughtByBuyer = standAPI.findAllVehicleByBuyer(buyerId);
        try {
            return new ResponseEntity<>(boughtByBuyer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("vehiclesByBrand")
    public ResponseEntity<List<VehicleDTO>> findByBrand(@RequestParam("brand") String brand) {
        List<VehicleDTO> vehiclesByBrand = standAPI.findByBrand(brand);
        try {
            return new ResponseEntity<>(vehiclesByBrand, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}