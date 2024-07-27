package com.filtrojava.entities.person.aplication;

import java.sql.SQLException;
import java.util.List;

import com.filtrojava.entities.person.domain.entity.person;
import com.filtrojava.entities.person.domain.service.personService;

public class FindPersonsBySkillsUseCase {

    private final personService personService;

    public FindPersonsBySkillsUseCase(personService personService) {
        this.personService = personService;
    }

    public List<person> execute(int id_skill) throws SQLException {
        return personService.findPersonsBySkill(id_skill);
    }
}
