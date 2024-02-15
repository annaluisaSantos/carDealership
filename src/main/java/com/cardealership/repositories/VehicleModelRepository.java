package com.cardealership.repositories;

import com.cardealership.domain.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
}
