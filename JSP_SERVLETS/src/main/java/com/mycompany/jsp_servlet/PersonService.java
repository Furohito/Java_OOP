package com.mycompany.jsp_servlet;

public class PersonService {

    public Person getPerson(int id) {
        switch (id) {
            case 1:
                return new Person(1, "John", 35);
            case 2:
                return new Person(2, "Jane", 45);
            case 3:
                return new Person(3, "Max", 65);
            default:
                return null;
        }
    }
}
