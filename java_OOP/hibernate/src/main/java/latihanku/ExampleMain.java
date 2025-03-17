package latihanku;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ExampleMain {
    public static void main(String[] args) {
        // Inisialisasi SessionFactory dengan konfigurasi Hibernate
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // Load konfigurasi dari hibernate.cfg.xml
                .addAnnotatedClass(Person.class) // Registrasi kelas Entity
                .buildSessionFactory()) {

            // Simpan data ke database
            persistData(sessionFactory);

            // Baca data dari database
            loadData(sessionFactory);
        }
    }

    private static void persistData(SessionFactory sessionFactory) {
        // Membuat objek Person
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);

        // Simpan ke database menggunakan Hibernate
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(person1); // Simpan objek ke database
            session.persist(person2);
            session.getTransaction().commit(); // Commit transaksi
        }
    }

    private static void loadData(SessionFactory sessionFactory) {
        // Ambil semua data dari tabel Person
        try (Session session = sessionFactory.openSession()) {
            List<Person> persons = session.createQuery("FROM Person", Person.class).list();
            System.out.println("\n--- Data di Database ---");
            persons.forEach(System.out::println); // Tampilkan data
        }
    }
}