package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ExampleMain {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        try {
            persist();
            load();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }

    private static void persist() {
        Person p1 = new Person("John", 35);
        Person p2 = new Person("Tina", 30);

        System.out.println("-- Persisting persons --");
        System.out.printf("-- %s%n%s%n", p1, p2);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(p1);
            session.save(p2);
            session.getTransaction().commit();
        }
    }

    private static void load() {
        System.out.println("-- Loading persons --");

        try (Session session = sessionFactory.openSession()) {
            List<Person> persons = session.createQuery("FROM Person", Person.class).list();
            persons.forEach(person -> System.out.printf("-- %s%n", person));
        }
    }
}
