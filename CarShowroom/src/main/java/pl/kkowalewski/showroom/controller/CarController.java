package pl.kkowalewski.showroom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.kkowalewski.showroom.exception.service.RepositoryItemNotFoundException;
import pl.kkowalewski.showroom.model.Car;
import pl.kkowalewski.showroom.service.car.CarService;

import java.util.List;

import static pl.kkowalewski.showroom.constant.Constants.BASE_PATH_CARS;
import static pl.kkowalewski.showroom.constant.Constants.PATH_EMPTY;
import static pl.kkowalewski.showroom.constant.Constants.PATH_PARAM_ID;
import static pl.kkowalewski.showroom.constant.Constants.SLASH;

@RequestMapping(BASE_PATH_CARS)
@RestController
public class CarController implements BaseController<Car> {

    /*------------------------ FIELDS REGION ------------------------*/
    private final CarService carService;

    /*------------------------ METHODS REGION ------------------------*/
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping({PATH_EMPTY, SLASH})
    @Override
    public List<Car> getAll() {
        return carService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(PATH_PARAM_ID)
    @Override
    public Car getById(@PathVariable Long id) {
        try {
            return carService.findById(id);
        } catch (RepositoryItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Car post(Car object) {
        return null;
    }

    @Override
    public Car put(Long id, Car object) {
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(PATH_PARAM_ID)
    @Override
    public void deleteById(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
