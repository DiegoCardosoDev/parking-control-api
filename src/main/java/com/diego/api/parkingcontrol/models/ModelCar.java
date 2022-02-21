package com.diego.api.parkingcontrol.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_MODELCAR")
public class ModelCar {

    private final  Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;


    @Column(nullable = false, unique = true, length = 7)
    private String lincesePlateCar;

    @Column(nullable = false, length = 70)
    private String brandCar;

    @Column(nullable = false, length = 70)
    private String modelCar;

    @Column(nullable = false, length = 70)
    private String colorCar;


}
