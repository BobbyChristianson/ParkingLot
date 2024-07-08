package ParkingLot.enums;

public enum VehicleSize {
    MOTORCYCLE(2),
    CAR(3);

    private int size;

    private VehicleSize(int size) { this.size = size; }

    public int getSize(){ return size; }
}
