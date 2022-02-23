package com.diego.api.parkingcontrol.services;

import com.diego.api.parkingcontrol.models.CarModel;
import com.diego.api.parkingcontrol.models.ParkingSpotModel;
import com.diego.api.parkingcontrol.repositories.CarModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    /*METODO PARA DELETAR VAGA*/
    @Transactional
    public void delete(CarModel parkingSpotModel) {
        carModelRepository.delete(parkingSpotModel);
    }

    /*METODO PARA LISTAR TODOS*/
    public List<CarModel> findAll() {
        return carModelRepository.findAll();
    }

    /*METODO PARA PROCURAR POR ID*/
    public Optional<CarModel> findById(Long id) {
        return carModelRepository.findById(id);
    }
}
