package com.filtrojava.entities.person.aplication;

import java.sql.SQLException;

import com.filtrojava.entities.person.domain.entity.person;
import com.filtrojava.entities.person.domain.service.personService;

public class FindPersonUseCase {

    private final personService personService;

    public FindPersonUseCase(personService personService) {
        this.personService = personService;
    }

    public person execute(int id) throws SQLException {
        return personService.findPersonByid(id);
    }
}
