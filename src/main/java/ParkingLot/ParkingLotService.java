package ParkingLot;

import ParkingLot.enums.ParkingSpotSize;
import ParkingLot.model.ParkingLot;
import ParkingLot.model.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public ParkingSpot createParkingSpot(Long parkingLotId, int row, int column, int floor, ParkingSpotSize size) {
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).orElseThrow(() -> new RuntimeException("Parking lot not found"));

        ParkingSpot parkingSpot = new ParkingSpot( row, column, floor, size, parkingLot);
        return parkingSpotRepository.save(parkingSpot);
    }

    public List<ParkingSpot> getParkingSpots(){
        return parkingSpotRepository.findAll();
    }

}
