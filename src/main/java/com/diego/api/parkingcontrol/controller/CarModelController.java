package com.diego.api.parkingcontrol.controller;

import com.diego.api.parkingcontrol.models.CarModel;
import com.diego.api.parkingcontrol.services.CarModelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot-car")
public class CarModelController {

    private final CarModelService carModelService;

    @PostMapping
    public ResponseEntity<Object> saveCar(@RequestBody CarModel carModel){

        if(carModelService.existsByLicensePlateCar(carModel.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        }



        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(carModel.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(carModelService.save(carModel));

    }




}
