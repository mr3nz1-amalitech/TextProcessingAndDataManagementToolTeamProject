package com.lab6.textprocessinganddatamanagementtoolteamproject.service;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.PersonDaoImpl;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.PersonModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

    @Mock
    private PersonDaoImpl personDao;

    @InjectMocks
    private PersonService personService;

    private AutoCloseable mocks;

    @Before
    public void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        mocks.close();
    }

    @Test
    public void testAddPerson() {
        String name = "firstName";
        int id = 1;
        PersonModel person = new PersonModel(id, name);
        when(personDao.add(person)).thenReturn(true);

        boolean result = personService.addPerson(person);
        assertTrue(result);
        verify(personDao, times(1)).add(person);
    }

    @Test
    public void testUpdatePerson() {

        String name = "firstName";
        int id = 1;
        PersonModel person = new PersonModel(id, name);
        when(personDao.update(person)).thenReturn(true);

        boolean result = personService.updatePerson(person);
        assertTrue(result);
        verify(personDao, times(1)).update(person);
    }

    @Test
    public void testDeletePerson() {
        int personId = 1;
        when(personDao.delete(personId)).thenReturn(true);

        boolean result = personService.deletePerson(personId);
        assertTrue(result);
        verify(personDao, times(1)).delete(personId);
    }

    @Test
    public void testGetPersonById() {
        int personId = 1;
        PersonModel person = new PersonModel(personId, "firstName");
        when(personDao.getById(personId)).thenReturn(person);

        PersonModel result = personService.getPersonById(personId);
        assertEquals(person, result);
        verify(personDao, times(1)).getById(personId);
    }

    @Test
    public void testGetAllPersons() {
        String name = "name";
        int id = 2;
        List<PersonModel> persons = List.of(new PersonModel(id, name), new PersonModel(id, name));
        when(personDao.getAll()).thenReturn(persons);

        List<PersonModel> result = personService.getAllPersons();
        assertEquals(persons, result);
        verify(personDao, times(1)).getAll();
    }
}
