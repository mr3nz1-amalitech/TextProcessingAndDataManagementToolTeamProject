package com.lab6.textprocessinganddatamanagementtoolteamproject.dao;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.interfaces.CarDao;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.CarModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDaoImpl implements CarDao {
    HashMap<String, Integer> cars = new HashMap<>();


    @Override
    public CarModel getById(CarModel car) {
        cars.put(car.getName(), car.getPrice());
        return car;
    }

    @Override
    public CarModel getById(int id) {
        return null;
    }

    @Override
    public List<CarModel> getAll() {
        return List.of();
    }

    @Override
    public Map<String, Integer> findAllCars() {
        return cars;
    }

    @Override
    public boolean add(CarModel person) {
        if (cars.get(person.getName()) != null) return false;

        cars.put(person.getName(), person.getPrice());

        return true;
    }

    @Override
    public boolean update(CarModel person) {
        if (cars.get(person.getName()) != null) return false;

        cars.put(person.getName(), person.getPrice());


        return true;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(String name) {
        if (cars.get(name) != null) return false;

        cars.remove(name);

        return false;
    }
}
