package com.filtrojava.entities.person.domain.entity;

public class person {
    private int id;
    private String name;
    private String lastname;
    private int id_city;
    private int age;
    private int id_gender;
    private String email;
    private String address;
    

    public person() {
        
    }


    public person(int id, String name, String lastname, int id_city, int age, int id_gender, String email,
            String address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.id_city = id_city;
        this.age = age;
        this.id_gender = id_gender;
        this.email = email;
        this.address = address;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public int getId_city() {
        return id_city;
    }


    public void setId_city(int id_city) {
        this.id_city = id_city;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public int getId_gender() {
        return id_gender;
    }


    public void setId_gender(int id_gender) {
        this.id_gender = id_gender;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

}
