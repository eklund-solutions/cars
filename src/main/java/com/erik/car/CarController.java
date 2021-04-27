package com.erik.car;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CarController {

    @Autowired
    private CarService CarService;

    @GetMapping(path="/")
    @CrossOrigin()
    String empty()
    {
        return "Car API för JAd-21 (Erik Eklund)";
    }

    // Hämta alla bilar
    @GetMapping(path="/car")
    @CrossOrigin()
    List<Car> getAll(){
        return CarService.getAll();
    }

    // Hämta angiven bil
    @GetMapping(path="/car/{id}")
    @CrossOrigin()
    Car getSingle(@PathVariable Integer id){
        return CarService.get(id);
    }
    
    // Skapa bil (POST). Förväntar oss JSON (definierad som)
    @PostMapping(path = "/car", consumes="application/json", produces="application/json")
    @CrossOrigin()
    ResponseEntity<Object> add(@RequestBody Car d) {
        CarService.addCar(d);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(d.getId())
        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    // Ta bort bil
    @DeleteMapping(path = "/car/{id}")
    @CrossOrigin()
    boolean deletePost(@PathVariable Integer id) {
        boolean status = false;
        // Kontrollera om bilen finns
        if( CarService.existsById(id) ) {
            // Ta då bort den
            CarService.deleteById(id);
            status = true;
        }        
        return status;
    }



}
