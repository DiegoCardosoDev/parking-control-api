package com.diego.api.parkingcontrol.repositories;

import com.diego.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    boolean existsLincencePlateCar(String licensePlateCar);

    boolean existsParkNumber(String licensePlateCar);
    public boolean existsByAPtoBlock(String apartament, String block);




}
