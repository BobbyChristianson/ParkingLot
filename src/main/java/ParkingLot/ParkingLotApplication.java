package ParkingLot;

import ParkingLot.enums.ParkingSpotSize;
import ParkingLot.model.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class ParkingLotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotApplication.class, args);
	}
}
