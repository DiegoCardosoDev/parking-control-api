package com.diego.api.parkingcontrol.models;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PARKINGSPOT")
public class ParkingSpotModel implements Serializable {

    private final  Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;


    @Column(nullable = false)
    private LocalDateTime registerDate;

    @Column(nullable = false, length = 30)
    private String reponsabilityName;

    @Column(nullable = false, length = 30)
    private String apartament;

    @Column(nullable = false, length = 30)
    private String block;

    @OneToOne
    @JoinColumn(name = "spot_id")
    private CarModel carModel;


}
