package com.lab6.textprocessinganddatamanagementtoolteamproject.dao;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.interfaces.PersonDao;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.PersonModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao {
    List<PersonModel> personList = new ArrayList<>();

    @Override
    public PersonModel getById(int id) {
        return personList.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<PersonModel> getAll() {
        return personList;
    }

    @Override
    public boolean add(PersonModel person) {
        return personList.add(person);
    }

    @Override
    public boolean update(PersonModel person) {
        Optional<PersonModel> existingPerson = personList.stream().filter(object -> object.getId() == person.getId()).findFirst();


        if (existingPerson.isEmpty()) return false;

        existingPerson.ifPresent(object -> {
            object.setName(person.getName());
        });


        return true;
    }

    @Override
    public boolean delete(int id) {
        List<PersonModel> people = personList.stream().filter(object -> object.getId() != id).toList();

        if (people.size() == personList.size()) return false;

        personList = people;
        return true;
    }
}
