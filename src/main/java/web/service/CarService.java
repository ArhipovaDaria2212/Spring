package web.service;

import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("hyundai", 2020, "blue"));
        cars.add(new Car("mazda", 2015, "gray"));
        cars.add(new Car("BMW", 2024, "white"));
        cars.add(new Car("porsche", 2023, "black"));
        cars.add(new Car("ferrari", 2019, "pink"));
    }

    public List<Car> getCars(Optional<Integer> count) {
        if (count.isPresent() && count.get() >= 0) {
            return cars.stream().limit(count.get()).collect(Collectors.toList());
        } else {
            return cars;
        }
    }
}
