package com.diego.api.parkingcontrol.dto;

import com.diego.api.parkingcontrol.models.CarModel;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class ParkingSpotDto {

    @NotBlank
    private String parkingSpotNumber;

    @NotBlank
    private String responsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;

    private CarModel carModel;



}
