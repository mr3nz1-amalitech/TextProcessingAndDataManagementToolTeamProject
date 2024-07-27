package com.lab6.textprocessinganddatamanagementtoolteamproject.dao.interfaces;

import com.lab6.textprocessinganddatamanagementtoolteamproject.model.CarModel;

import java.util.Map;

public interface CarDao extends Dao<CarModel> {
    Map<String, Integer> findAllCars();

    CarModel getById(CarModel car);

    boolean delete(String name);
}
