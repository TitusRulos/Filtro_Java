package com.filtrojava.entities.person.aplication;

import java.sql.SQLException;

import com.filtrojava.entities.person.domain.service.personService;

public class DelatePersonUseCase {

private final personService personService;

public DelatePersonUseCase(personService personService){
    this.personService = personService;
}

public void execute(int id) throws SQLException{
    personService.deletePersonById(id);
}
}

