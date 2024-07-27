package com.filtrojava.entities.person.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.filtrojava.config.dbconfig;
import com.filtrojava.entities.person.domain.entity.person;
import com.filtrojava.entities.person.domain.service.personService;

public class PersonRepository implements personService {

    public static final String UserUseCase = null;

    @Override
    public void createPerson(person person) {
        String sql = "INSERT INTO persons(id, name, lastname, idcity,address,age,email,idgender) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection connection = dbconfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, person.getLastname());
            statement.setInt(4, person.getId_city());
            statement.setInt(5, person.getAge());
            statement.setInt(6, person.getId_gender());
            statement.setString(7, person.getEmail());
            statement.setString(8, person.getAddress());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    person.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<person> findPersonsBySkill(int id_skill) {
    List<person> persons = new ArrayList<>();
    
    String sql = "SELECT id, name FROM persons WHERE skill_id = ?";
    
    try (Connection connection = dbconfig.getConnection(); 
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id_skill); 
        
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {  
                person person = new person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return persons;
}


    @Override
    public person updateById(int id, String name, String lastname, int id_city, int age, int id_gender, String email, String address) {
        String sql = "UPDATE persons SET name = ?, lastname = ?, id_city = ?, age = ?, id_gender = ?, email = ?, address = ? WHERE id = ?";
        try (Connection connection = dbconfig.getConnection();PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, lastname);
            statement.setInt(3, id_city);
            statement.setInt(4, age);
            statement.setInt(5, id_gender);
            statement.setString(6, email);
            statement.setString(7, address);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public person deletePersonById(int id) {
        String sql = "DELETE FROM persons WHERE id = ?";
        try (Connection connection = dbconfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setLong(1, id);
            int rowsDeleted = statement.executeUpdate();
            
            if (rowsDeleted > 0) {
                System.out.println("Usuario con ID " + id + " eliminado correctamente.");
          
            } else {
                System.out.println("No se encontró ningún usuario con ID " + id + " para eliminar.");
            }
    
        } catch (SQLException e) {
            System.out.println("error try : " + e);
    
        }
        
        return null;
    }

    @Override
    public person findPersonByid(int id) {
       String sql = "select id, name, email from persons where id = ?";
       person person = null;
       try(Connection connection = dbconfig.getConnection();PreparedStatement statement = connection.prepareStatement(sql)){
        statement.setLong(1, id);
        try(ResultSet resultSet = statement.executeQuery()){
            if (resultSet.next()) {
                person = new person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
            }
        }
        
       } catch (SQLException e) {
        
        e.printStackTrace();
    }
    return person;
       
    }



}