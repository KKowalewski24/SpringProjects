package pl.kkowalewski.showroom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kkowalewski.showroom.model.Car;
import pl.kkowalewski.showroom.model.Engine;
import pl.kkowalewski.showroom.model.Showroom;
import pl.kkowalewski.showroom.model.type.BrandType;
import pl.kkowalewski.showroom.model.type.EngineType;
import pl.kkowalewski.showroom.service.car.CarService;
import pl.kkowalewski.showroom.service.showroom.ShowroomService;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final CarService carService;
    private final ShowroomService showroomService;

    public DemoApplication(CarService carService, ShowroomService showroomService) {
        this.carService = carService;
        this.showroomService = showroomService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Showroom showroom = new Showroom("Porsche Centrum", "Lodz");
        Car audiRs6 = new Car(BrandType.AUDI, new Engine(EngineType.V8, 4.0f), showroom);
        Car porscheMacan = new Car(BrandType.PORSCHE, new Engine(EngineType.V6, 3.0f), showroom);
        showroom.setCars(List.of(audiRs6, porscheMacan));
        showroomService.save(showroom);
        carService.save(audiRs6);
        carService.save(porscheMacan);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
