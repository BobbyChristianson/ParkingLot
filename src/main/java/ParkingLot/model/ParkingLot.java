package ParkingLot.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private int levels;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingLot() {}

    public ParkingLot(String name, String address, int levels) {
        this.name = name;
        this.address = address;
        this.levels = levels;
    }

    @Override
    public String toString() {
        return name;
    }
}
