package com.filtrojava.entities.person.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.filtrojava.entities.person.domain.entity.person;


public interface personService {
    void createPerson(person person) throws SQLException;
    List<person> findPersonsBySkill(int id_skill) throws SQLException;
    person updateById(int id, String name, String lastname, int id_city, int age, int id_gender, String email, String address)throws SQLException;
    person deletePersonById(int id) throws SQLException;
    person findPersonByid(int id) throws SQLException;
}
