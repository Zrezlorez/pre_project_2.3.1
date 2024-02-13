package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    private final List<Car> cars = new ArrayList<>() {{
        add(new Car("Bmw", 1, 200));
        add(new Car("Tesla", 5, 13000));
        add(new Car("Mercedes", 7, 25200));
        add(new Car("Audi", 8, 0));
        add(new Car("Ferari", 3, 5000));
    }};
    @Override
    public List<Car> getCars(int count) {
        return cars.stream().limit(count).toList();
    }
}
