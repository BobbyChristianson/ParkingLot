package ParkingLot.model;

import ParkingLot.enums.ParkingSpotSize;
import jakarta.persistence.*;

@Entity
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int spotRow;
    private int spotColumn;
    private int floor;
    @Enumerated(EnumType.STRING)
    private ParkingSpotSize size;
    @OneToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "parkingLotId")
    private ParkingLot parkingLot;

    public ParkingSpot() {
    }

    public ParkingSpot(int row, int column, int floor, ParkingSpotSize size, ParkingLot parkingLot) {
        this.spotRow = row;
        this.spotColumn = column;
        this.floor = floor;
        this.size = size;
        this.parkingLot = parkingLot;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", spotRow=" + spotRow +
                ", spotColumn=" + spotColumn +
                ", floor=" + floor +
                ", size=" + size.toString() +
                ", vehicle=" + vehicle +
                ", parkingLot=" + parkingLot +
                '}';
    }

    public ParkingSpotSize getParkingSpotSize(){
        return size;
    }

    public int calculateDistance() {
        return spotRow + spotColumn + (spotRow + spotColumn) * floor;
    }

    public int getFloor(){ return floor; }
    public boolean isAvailable(){
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle v){
        return isAvailable() && vehicle.canFitVehicle(this);
    }
}
