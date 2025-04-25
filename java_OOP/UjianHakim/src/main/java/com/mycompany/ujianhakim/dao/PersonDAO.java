package com.mycompany.ujianhakim.dao;

import com.mycompany.ujianhakim.model.Person;
import com.mycompany.ujianhakim.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PersonDAO {
    public List<Person> getAllPersons() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Person", Person.class).list();
        }
    }

    public void savePerson(Person person) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Tambahkan method ini
    public void deletePerson(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            if (person != null) {
                session.delete(person);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}