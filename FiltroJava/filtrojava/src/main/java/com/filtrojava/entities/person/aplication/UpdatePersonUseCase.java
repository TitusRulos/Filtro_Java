package com.filtrojava.entities.person.aplication;

import java.sql.SQLException;

import com.filtrojava.entities.person.domain.entity.person;
import com.filtrojava.entities.person.domain.service.personService;


public class UpdatePersonUseCase {

    private final personService personService;

    public UpdatePersonUseCase(personService personService) {
        this.personService = personService;
    }

    public person execute(int id, String name, String lastname, int id_city, int age, int id_gender, String email, String address) throws SQLException {
        return personService.updateById(id,name,lastname,id_city,age,id_gender,email,address);
    }
}