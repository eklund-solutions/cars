package com.erik.car;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



public class CarServiceTests {
    CarRepository CarRepository;
    ArrayList<Car> testlist;
    @BeforeEach
    void init()
    {
        testlist = new ArrayList<Car>();
        testlist.add(new Car());
        testlist.add(new Car());
        testlist.add(new Car());
        CarRepository = Mockito.mock(CarRepository.class); 
        when(CarRepository.findAll()).thenReturn(testlist);
    }

    @Test
    void getAllShouldReturnAllRecords()
    {
        var sut = new CarService(CarRepository);
        assertArrayEquals( testlist.toArray() ,sut.getAll().toArray());            
    }

    
}
