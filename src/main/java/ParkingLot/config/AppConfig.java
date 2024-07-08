package ParkingLot.config;

import ParkingLot.ParkingLotRepository;
import ParkingLot.ParkingSpotRepository;
import ParkingLot.enums.ParkingSpotSize;
import ParkingLot.model.ParkingLot;
import ParkingLot.model.ParkingSpot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner initialize(ParkingLotRepository parkingLotRepository, ParkingSpotRepository parkingSpotRepository){
        return args -> {
            ParkingLot lot1 = new ParkingLot("Lot 1", "4545 La Jolla Village Drive,", 2);
            parkingLotRepository.save(lot1);

            int counter = 1;
            for(int f = 1; f <= 2; f++) {
                for (int row = 1; row <= 22; row++) {
                    for (int column = 1; column <= 10; column++) {
                        parkingSpotRepository.save(new ParkingSpot(row, column, f, counter++%4 == 0 ? ParkingSpotSize.SMALL : ParkingSpotSize.REGULAR, lot1));
                    }
                }
            }
        };
    }
}
