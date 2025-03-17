package com.example;

import javax.persistence.*;

@Entity
@Table(name = "person") // Pastikan tabel memiliki nama yang benar
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id;

    private String name;
    private int age;

    // Constructor default (penting untuk Hibernate)
    public Person() {}

    // Constructor dengan parameter
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
