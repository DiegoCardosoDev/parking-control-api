package com.diego.api.parkingcontrol.controller;


import com.diego.api.parkingcontrol.dto.ParkingSpotDto;
import com.diego.api.parkingcontrol.exeptions.ParkSpotExeption;
import com.diego.api.parkingcontrol.models.CarModel;
import com.diego.api.parkingcontrol.models.ParkingSpotModel;
import com.diego.api.parkingcontrol.services.CarModelService;
import com.diego.api.parkingcontrol.services.ParkingSpotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    /*INJEÇAO DO SERVICE*/
    final ParkingSpotService parkingSpotService;
    final CarModelService carModelService;

    /*IMPLEMENTAÇÃO DO METODO CRIAR UMA VAGA*/
    @PostMapping(value = "create")
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) throws ParkSpotExeption{

        try {

            if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
            }
            if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body
                        ("Conflict: Parking Spot already registered for this apartment/block!");
            }
            var parkingSpotModel = new ParkingSpotModel();
            BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
            parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
            parkingSpotService.save(parkingSpotModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("PARKINGSPOT CREATED SUCCESS!");

        }catch (ParkSpotExeption exeption){
            log.error("error created parkingspot...");
            exeption.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
    }

    /*IMPLEMENTAÇÃO DO METODO PARA PROCURAR POR ID*/
    @GetMapping( "/{id}")
    public ResponseEntity<Object> getParkingSpotId(@PathVariable (value = "id")Long id){

        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        Optional<CarModel> optionalCarModel = carModelService.findById(id);


        if (parkingSpotModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }

    /*IMPLEMENTAÇÃO DO METODO PARA DELETAR A VAGA*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") Long id){

        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        Optional<CarModel> optionalCarModel = carModelService.findById(id);

        if (parkingSpotModelOptional.isEmpty() && optionalCarModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        parkingSpotService.delete(parkingSpotModelOptional.get());
        carModelService.delete(optionalCarModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
    }

    /*IMPLEMENTAÇÃO DO METODO PARA ATUALIZAR A VAGA*/
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid ParkingSpotDto parkingSpotDto){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (parkingSpotModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }

        var parkingSpotModel = new ParkingSpotModel();

        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
        parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
    }

    @GetMapping(value = "list-all")
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }



}
