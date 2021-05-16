package pl.kkowalewski.showroom.service.car;

import org.springframework.stereotype.Service;
import pl.kkowalewski.showroom.exception.service.CarNotFoundException;
import pl.kkowalewski.showroom.exception.service.RepositoryItemNotFoundException;
import pl.kkowalewski.showroom.model.Car;
import pl.kkowalewski.showroom.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CarServiceImpl implements CarService {

    /*------------------------ FIELDS REGION ------------------------*/
    private final CarRepository carRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car findById(Long id) throws RepositoryItemNotFoundException {
        return carRepository
                .findById(id)
                .orElseThrow(CarNotFoundException::new);
    }

    @Override
    public List<Car> findAll() {
        return StreamSupport
                .stream(carRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Car save(Car object) {
        return carRepository.save(object);
    }

    @Override
    public Car update(Car object) {
        return carRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void delete(Car object) {
        carRepository.delete(object);
    }

    @Override
    public void deleteAll() {
        carRepository.deleteAll();
    }
}
