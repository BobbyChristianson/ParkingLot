package ParkingLot.enums;

public enum ParkingSpotSize {
    SMALL(2, "SMALL"),
    REGULAR(3, "REGULAR");

    private int size;
    private String name;

    private ParkingSpotSize(int size, String name) { this.size = size; this.name = name; }

    public int getSize() { return size; }

    public String getName() { return name; }

    @Override
    public String toString() { return getName(); }
}
