package com.cardealership.repositories;

import com.cardealership.domain.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, String> {
    Optional<VehicleModel> findByName(String name);
}
