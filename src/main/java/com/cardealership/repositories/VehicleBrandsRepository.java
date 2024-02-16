package com.cardealership.repositories;

import com.cardealership.domain.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleBrandsRepository extends JpaRepository<VehicleBrand, String> {
    Optional<VehicleBrand> findByName(String name);

}
