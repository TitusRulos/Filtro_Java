package com.filtrojava;

import java.sql.SQLException;
import java.util.Scanner;

import com.filtrojava.entities.person.infrastructure.in.PersonConsoleAdapter;
import com.filtrojava.entities.person.infrastructure.out.PersonRepository;



public class Main {
    public static void main(String[] args) throws SQLException {
        try(Scanner scanner = new Scanner(System.in)){
            boolean salir = false;
            PersonRepository personRepository = new PersonRepository();


            while (!salir) {
                System.out.println("Elige una opción: ");
                System.out.println("1. Registrar persona");
                System.out.println("2. Asignar habilidad");
                System.out.println("3. Crear una habilidad");
                System.out.println("4. Consultar persona por habilidad");
                System.out.println("5. Actualizar persona");
                System.out.println("6. Eliminar persona");
                System.out.println("7. Salir");
                int option = scanner.nextInt();
                scanner.nextLine();
                
                switch (option) {
                    case 1 -> {
                        PersonConsoleAdapter personConsoleAdapter = new PersonConsoleAdapter(personRepository);
                        personConsoleAdapter.createPerson();
                    }
                    case 2 -> {
                        System.out.println("2");
                    }
                    case 3 -> {
                        System.out.println("3");
                    }
                    case 4 -> {
                        PersonConsoleAdapter personConsoleAdapter = new PersonConsoleAdapter(personRepository);
                        personConsoleAdapter.updatePerson();
                    }
                    case 5 -> {
                        PersonConsoleAdapter personConsoleAdapter = new PersonConsoleAdapter(personRepository);
                        personConsoleAdapter.createPerson();
                    }
                    case 6 -> {
                        PersonConsoleAdapter personConsoleAdapter = new PersonConsoleAdapter(personRepository);
                        personConsoleAdapter.deletePerson();
                    }
                    case 7 ->{
                        salir = true;
                        break;
                    } 
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 4");
                }
            }
        }
    }
}