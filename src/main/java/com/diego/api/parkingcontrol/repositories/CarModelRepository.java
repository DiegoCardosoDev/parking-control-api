package com.diego.api.parkingcontrol.repositories;

import com.diego.api.parkingcontrol.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    boolean existsByLicensePlateCar(String licensePlateCar);


}
