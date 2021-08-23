package ru.viktor.lesson231.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;


    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User() {

    }
}

