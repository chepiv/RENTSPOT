package domain_core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by chepiv on 20.01.2019.
 * Contact: chepurin.ivan@gmail.com
 * Github:chepiv
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-rentspot");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Landlord landlord = new Landlord();
        landlord.setName("Test");
        landlord.setSurname("Testowic");
        landlord.setPhone("888-888-888");
        landlord.setEmail("lalal@lal.cc");
        landlord.setPassword("3124124!@#!@3123$!@");

        entityManager.persist(landlord);

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
