package com.diego.api.parkingcontrol.services;


import com.diego.api.parkingcontrol.models.ParkingSpotModel;
import com.diego.api.parkingcontrol.repositories.ParkingSpotRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Data
@Service
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkSpotModel) {
        return parkingSpotRepository.save(parkSpotModel);

    }

    public boolean existsLincencePlateCar(String lincesePlateCar) {
        return parkingSpotRepository.existsLincencePlateCar(lincesePlateCar);
    }

    public boolean existsParkNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsParkNumber(parkingSpotNumber);
    }

    public boolean existsByAPtoBlock(String apartament, String block) {
        return parkingSpotRepository.existsByAPtoBlock(apartament, block);
    }
}
