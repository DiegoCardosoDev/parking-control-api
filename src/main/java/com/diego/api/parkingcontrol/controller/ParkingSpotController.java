package com.diego.api.parkingcontrol.controller;


import com.diego.api.parkingcontrol.dto.ParkingSpotDto;
import com.diego.api.parkingcontrol.exeptions.ParkSpotExeption;
import com.diego.api.parkingcontrol.models.ParkingSpotModel;
import com.diego.api.parkingcontrol.services.ParkingSpotService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    /*INJEÇAO DO SERVICE*/
    final ParkingSpotService parkingSpotService;

    /*IMPLEMENTAÇÃO DO METODO CRIAR UMA VAGA*/


    @PostMapping(value = "create")
    public ResponseEntity<String> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) throws ParkSpotExeption{

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
            exeption.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
    }

    /*IMPLEMENTAÇÃO DO METODO PARA DELETAR A VAGA*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") Long id){

        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);

        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        parkingSpotService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
    }

    /*IMPLEMENTAÇÃO DO METODO PARA ATUALIZAR A VAGA*/
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid ParkingSpotDto parkingSpotDto){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
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
