package com.cardealership.repositories;

import com.cardealership.domain.Vehicle;
import com.cardealership.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByVin(String vin);

// Find in database all vehicles in stock
@Query("SELECT v FROM Vehicle v WHERE v.state = :state")
List<Vehicle> findByState(State state);

    // Find in database all vehicles sold
//    @Query("SELECT v FROM Vehicle v WHERE v.state = :sold")
//    List<Vehicle> findAllVehicleSold(@Param("sold") State state);

    @Query("SELECT v FROM Vehicle v WHERE v.idBuyer = :idBuyer")
    List<Vehicle> findAllVehicleByBuyer(@Param("idBuyer") int idBuyer);
}

