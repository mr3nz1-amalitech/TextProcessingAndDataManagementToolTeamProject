package com.lab6.textprocessinganddatamanagementtoolteamproject.dao.interfaces;

import java.util.List;
import java.util.Map;

public interface Dao<T> {
    T getById(int id);

    List<T> getAll();

    boolean add(T person);

    boolean update(T person);

    boolean delete(int id);

}
