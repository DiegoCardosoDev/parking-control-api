package com.diego.api.parkingcontrol.services;


import com.diego.api.parkingcontrol.models.ParkingSpotModel;
import com.diego.api.parkingcontrol.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ParkingSpotService {

    /*INJEÇÃO DO REPOSITORY*/
    private final ParkingSpotRepository parkingSpotRepository;



    /*METODO PARA SALVAR A VAGA NO SISTEMA*/
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkSpotModel) {
        return parkingSpotRepository.save(parkSpotModel);

    }

    /*METODO PARA LISTAR TODOS*/
    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        return parkingSpotRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }



    /*METODO PARA VERIFICAR A LICENÇA*/
    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    /*METODO PARA VERIFICAR O NUMERO DA VAGA, SE JÁ EXITE*/
    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    /*METODO PARA VERIFICAR O NUMERO DO BLOCO E APARTAMENTO SE JA EXISTE*/
    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }


    /*METODO PARA DELETAR VAGA*/
    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }

    /*METODO PARA PROCURAR POR ID*/
    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }


}
