package com.lab6.textprocessinganddatamanagementtoolteamproject.service;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.CarDaoImpl;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.CarModel;

import java.util.Map;

public class CarService {
    CarDaoImpl carDao = new CarDaoImpl();

    public Map<String, Integer> findAllCars() {
        return carDao.findAllCars();
    }

    public boolean add(CarModel person) {
        return carDao.add(person);
    }

    public boolean update(CarModel person) {
        return carDao.update(person);
    }

    public boolean delete(String name) {
        return carDao.delete(name);
    }

    public CarModel getCar(String name) {
        return carDao.getCar(name);
    }
}