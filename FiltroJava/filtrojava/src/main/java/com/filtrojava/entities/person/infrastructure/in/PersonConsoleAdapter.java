package com.filtrojava.entities.person.infrastructure.in;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

import com.filtrojava.entities.person.domain.entity.person;
import com.filtrojava.entities.person.domain.service.personService;


public class PersonConsoleAdapter {
    private final Scanner sc = new Scanner(System.in);
    private final personService personService;

    

    public PersonConsoleAdapter(personService personService) {
        this.personService = personService;
    }

    public void createPerson() throws SQLException {
        String option = "S";
        while (option.equalsIgnoreCase("S")) {
            System.out.println("INGRESE EL ID DE LA PERSONA: ");
            int id = sc.nextInt();
            sc.nextLine();
            Optional<person> person = Optional.ofNullable(personService.findPersonByid(id));
            person.ifPresentOrElse(a -> {
                System.out.println("LA PERSONA YA EXISTE");
                System.out.println("PRESIONE CUALQUIER TECLA PARA SEGUIR");
                sc.nextLine();
            }, () -> {
                System.out.println("INGRESE EL NOMBRE DE LA PERSONA");
                String name = sc.nextLine();
                System.out.println("INGRESE EL APELLIDO DE LA PERSONA");
                String lastname = sc.nextLine();
                System.out.println("INGRESE EL ID DE LA CIUDAD DE LA PERSONA");
                int id_city = sc.nextInt();
                sc.nextLine();
                System.out.println("INGRESE LA EDAD DE LA PERSONA");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.println("INGRESE EL ID DEL GÉNERO DE LA PERSONA");
                int id_gender = sc.nextInt();
                sc.nextLine();
                System.out.println("INGRESE EL EMAIL DE LA PERSONA");
                String email = sc.nextLine();
                System.out.println("INGRESE LA DIRECCION DE LA PERSONA");
                String address = sc.nextLine();
                person newPerson = new person(id,name,lastname,id_city,age,id_gender,email,address);
                try {
                    personService.createPerson(newPerson);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("¿DESEA CREAR OTRA PERSONA? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();
        }
    }


    public void updatePerson() throws SQLException {
        System.out.println("INGRESE EL ID DE LA PERSONA A EDITAR:");
        int person_id = sc.nextInt();
        sc.nextLine();
        Optional<person> person = Optional.ofNullable(personService.findPersonByid(person_id));
        person.ifPresentOrElse(a -> {
            System.out.println("ID: " + a.getId() + " NOMBRE: " + a.getName() + " ID CIUDAD: " + a.getId_city() + "");
            System.out.println("INGRESE EL NUEVO NOMBRE DE LA PERSONA:");
            String newName = sc.nextLine();
            System.out.println("INGRESE EL NUEVO APELLIDO DE LA PERSONA:");
            String newlastname = sc.nextLine();
            System.out.println("INGRESE EL ID DE LA NUEVA CIUDAD DE LA PERSONA:");
            int newCity = sc.nextInt();
            sc.nextLine();
            System.out.println("INGRESE LA NUEVA EDAD DE LA PERSONA:");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("INGRESE EL ID DEL NUEVO GÉNERO DE LA PERSONA:");
            int id_gender = sc.nextInt();
            sc.nextLine();
            System.out.println("INGRESE EL NUEVO EMAIL DE LA PERSONA:");
            String email = sc.nextLine();
            System.out.println("INGRESE LA NUEVA DIRECCION DE LA PERSONA:");
            String address = sc.nextLine();

            try {
                personService.updateById(a.getId(), newName,newlastname, newCity, age,id_gender,email,address);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, () -> System.out.println("AEROPUERTO NO ENCONTRADO"));
        System.out.println("PRESIONE CUALQUIER TECLA PARA SEGUIR");
        sc.nextLine();
    }
    public void deletePerson() throws SQLException{
        System.out.println("INGRESE EL ID DE LA PERSONA A ELIMINAR");
        int person_id = sc.nextInt();
        sc.nextLine();
        Optional<person> person = Optional.ofNullable(personService.findPersonByid(person_id));
        person.ifPresentOrElse(a->{
            try {
                personService.deletePersonById(person_id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("PERSONA ELIMINADO");
        }, ()-> System.out.println("PERSONA NO ENCONTRADO"));

        System.out.println("PRESIONE CUALQUIER TECLA PARA SEGUIR");
        sc.nextLine();
    }
}

    
