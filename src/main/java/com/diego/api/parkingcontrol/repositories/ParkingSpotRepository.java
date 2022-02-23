package com.diego.api.parkingcontrol.repositories;

import com.diego.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, Long> {


   boolean existsByParkingSpotNumber(String parkingSpotNumber);
   boolean existsByApartmentAndBlock(String apartment, String block);
}
