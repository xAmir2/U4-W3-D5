package amirka.dao;

import amirka.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(User user) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(user);

        transaction.commit();
    }
}
