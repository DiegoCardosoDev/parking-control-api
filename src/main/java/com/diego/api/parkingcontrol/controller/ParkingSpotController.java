package com.diego.api.parkingcontrol.controller;


import com.diego.api.parkingcontrol.dto.ParkingSpotDto;
import com.diego.api.parkingcontrol.models.ParkingSpotModel;
import com.diego.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/parking-spot")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> savePark(@RequestBody @Valid ParkingSpotDto  parkingSpotDto){
        if (parkingSpotService.existsLincencePlateCar(parkingSpotDto.getLincesePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Lincese Plate car in Use");
        }
        if (parkingSpotService.existsParkNumber(parkingSpotDto.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: EM USO!");
        }
        if (parkingSpotService.existsByAPtoBlock(parkingSpotDto.getApartament(),parkingSpotDto.getBlock())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("conflict: ja registrado!");
        }




        var parkSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkSpotModel);
        parkSpotModel.setRegisterDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkSpotModel));
    }


}
