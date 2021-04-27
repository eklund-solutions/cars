package com.erik.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository CarRepository;

    CarService(CarRepository CarRepository) {
        super();
        this.CarRepository = CarRepository;
    }

    List<Car> getAll(){
        var l = new ArrayList<Car>();
        for(Car r : CarRepository.findAll())
        {
            l.add(r);
        }
        return l;
    }

    Car get(Integer id){
        return CarRepository.findById(id).get();
    }

    Car addCar(Car d){
        return CarRepository.save(d);
    }

    Boolean existsById(int id) {
        return CarRepository.existsById(id);
    }
    
    void deleteById(int id) {
        CarRepository.deleteById(id);
    }
    
}
