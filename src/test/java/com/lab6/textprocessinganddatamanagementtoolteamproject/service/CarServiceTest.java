package com.lab6.textprocessinganddatamanagementtoolteamproject.service;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.CarDaoImpl;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.CarModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class CarServiceTest {

    @Mock
    private CarDaoImpl carDao;

    @InjectMocks
    private CarService carService;

    private AutoCloseable mocks;

    @Before
    public void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        mocks.close();
    }
    String name;
    int price;

    @Test
    public void testFindAllCars() {
        Map<String, Integer> cars = mock(Map.class);
        when(carDao.findAllCars()).thenReturn(cars);

        Map<String, Integer> result = carService.findAllCars();
        assertEquals(cars, result);
        verify(carDao, times(1)).findAllCars();
    }

    @Test
    public void testAdd() {
        CarModel car = new CarModel(name , price);
        when(carDao.add(car)).thenReturn(true);

        boolean result = carService.add(car);
        assertEquals(true, result);
        verify(carDao, times(1)).add(car);
    }

    @Test
    public void testUpdate() {
        CarModel car = new CarModel(name, price);
        when(carDao.update(car)).thenReturn(true);

        boolean result = carService.update(car);
        assertEquals(true, result);
        verify(carDao, times(1)).update(car);
    }

    @Test
    public void testDelete() {
        String name = "TestCar";
        when(carDao.delete(name)).thenReturn(true);

        boolean result = carService.delete(name);
        assertEquals(true, result);
        verify(carDao, times(1)).delete(name);
    }

    @Test
    public void testGetCar() {
        String name = "TestCar";
        int price = 10;
        CarModel car = new CarModel(name, price);
        when(carDao.getCar(name)).thenReturn(car);

        CarModel result = carService.getCar(name);
        assertEquals(car, result);
        verify(carDao, times(1)).getCar(name);
    }

    @Test
    public void testGetNonExistingCar() {
        String name = "NonExistingCar";
        when(carDao.getCar(name)).thenReturn(null);

        CarModel result = carService.getCar(name);
        assertNull(result);
        verify(carDao, times(1)).getCar(name);
    }
}
