package ParkingLot;

import ParkingLot.enums.ParkingSpotSize;
import ParkingLot.model.ParkingSpot;

import javax.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;

@RestController
@RequestMapping("api/parkinglot")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping("/findSpot")
    public String getClosestParkingSpot(@RequestParam(value = "name", required = false, defaultValue = "")
                                        String name){
        return parkingLotService.getParkingSpots().stream()
                .filter((spot) -> spot.getParkingSpotSize() == (name.equals("small") ? ParkingSpotSize.SMALL : ParkingSpotSize.REGULAR))
                .min(Comparator.comparingInt(ParkingSpot::calculateDistance))
                .orElseThrow().toString();
    }
}
