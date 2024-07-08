package ParkingLot.model;

import ParkingLot.enums.ParkingSpotSize;
import jakarta.persistence.*;

@Entity
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected int licence;

    @OneToOne
    @JoinColumn(name = "parkingSpotId")
    protected ParkingSpot spot;
    @Enumerated(EnumType.STRING)
    protected ParkingSpotSize type;

    public boolean canFitVehicle(ParkingSpot spot){
        return spot.getParkingSpotSize() == type;
    }

}
