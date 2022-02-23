package com.diego.api.parkingcontrol.services;

import com.diego.api.parkingcontrol.models.CarModel;
import com.diego.api.parkingcontrol.repositories.CarModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class CarModelService {

    private final CarModelRepository carModelRepository;

    /*METODO PARA VERIFICAR A LICENÇA*/
    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return carModelRepository.existsByLicensePlateCar(licensePlateCar);
    }


    @Transactional
    public CarModel save(CarModel carModel) {
        return carModelRepository.save(carModel);

    }
}
