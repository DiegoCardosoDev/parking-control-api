package com.diego.api.parkingcontrol.exeptions;

public class ParkSpotExeption extends RuntimeException{

    public ParkSpotExeption(String message) {
        super(message);
    }
}
