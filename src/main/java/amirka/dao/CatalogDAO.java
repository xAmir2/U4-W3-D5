package amirka.dao;

import amirka.entities.Book;
import amirka.entities.Catalog;
import amirka.exceptions.NotFound;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CatalogDAO {
    private final EntityManager entityManager;

    public CatalogDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Catalog newCatalog) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newCatalog);

        transaction.commit();

        System.out.println(newCatalog + "was successfully saved!");
    }

    public Catalog findByIsbn(String isbn) {
        try {
            TypedQuery<Catalog> query = entityManager.createQuery("SELECT c FROM Catalog c WHERE c.isbn=:isbn",
                    Catalog.class);
            query.setParameter("isbn", isbn);

            return query.getSingleResult();
        } catch (NoResultException ex) {
            throw new NotFound("No catalog found using:" + isbn);
        }
    }

    public void deleteUsingIsbn(String isbn) {
        Catalog found = findByIsbn(isbn);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(found);

        transaction.commit();
    }

    public List<Catalog> findByYear(int year) {
        TypedQuery<Catalog> query = entityManager.createQuery("SELECT c FROM Catalog c WHERE c.publicationYear=:year",
                Catalog.class);

        query.setParameter("year", year);

        return query.getResultList();
    }

    public List<Book> findByAuthor(String author) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.author=:author", Book.class);

        query.setParameter("author", author);

        return query.getResultList();
    }

    public List<Catalog> fingByTitle(String title) {
        TypedQuery<Catalog> query = entityManager.createQuery("SELECT c FROM Catalog c WHERE c.title LIKE :title",
                Catalog.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }
}
