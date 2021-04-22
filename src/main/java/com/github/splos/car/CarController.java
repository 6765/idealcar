package com.github.splos.car;

import com.github.splos.car.CarView.Public;
import com.github.splos.car.CarView.WithComments;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CarController {

  private final CarRepository carRepository;

  public CarController(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @PostMapping("/api/car")
  public Car create(@Valid @RequestBody CarRequest request) {
    Car car = new Car();
    car.setMaker(request.getMaker());
    car.setModel(request.getModel());
    car.setPower(request.getPower());
    car.setNumberOfPlaces(request.getNumberOfPlaces());

    carRepository.save(car);

    return car;
  }

  @GetMapping("/api/car/{carId}")
  public MappingJacksonValue getAll(@PathVariable Long carId, Principal principal) {
    Car car = carRepository.findById(carId).orElse(null);
    if (car == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    final MappingJacksonValue result = new MappingJacksonValue(car);
    Class<? extends Public> view = Public.class;
    if (principal != null) {
      view = WithComments.class;
    }

    result.setSerializationView(view);

    return result;
  }
}
