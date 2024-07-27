package com.filtrojava.entities.person.aplication;

import java.sql.SQLException;

import com.filtrojava.entities.person.domain.entity.person;
import com.filtrojava.entities.person.domain.service.personService;

public class CreatePersonUseCase {

private final personService personService;

public CreatePersonUseCase(personService personService){
    this.personService = personService;
}

public void execute(person person) throws SQLException{
    personService.createPerson(person);
}
}

