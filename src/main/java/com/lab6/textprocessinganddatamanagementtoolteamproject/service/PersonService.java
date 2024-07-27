package com.lab6.textprocessinganddatamanagementtoolteamproject.service;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.PersonDaoImpl;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.PersonModel;

import java.util.List;

public class PersonService {
    PersonDaoImpl personDao = new PersonDaoImpl();

    public PersonService() {
        this.personDao = new PersonDaoImpl();
    }

    public boolean addPerson(PersonModel person) {
        return personDao.add(person);
    }

    public boolean updatePerson(PersonModel person) {
        return personDao.update(person);
    }

    public boolean deletePerson(int id) {
        return personDao.delete(id);
    }

    public PersonModel getPersonById(int id) {
        return personDao.getById(id);
    }

    public List<PersonModel> getAllPersons() {
        return personDao.getAll();
    }
}
