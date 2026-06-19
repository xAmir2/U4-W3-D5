package amirka.dao;

import amirka.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class LoanDAO {
    private EntityManager entityManager;

    public LoanDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Loan newLoan) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newLoan);

        transaction.commit();
        System.out.println(newLoan + "was successfully saved!");

    }

    public List<Loan> findCurrentlyInLoans(String membership) {
        TypedQuery<Loan> query = entityManager.createQuery(
                "SELECT l FROM Loan l WHERE l.user.membershipNumber=:membership AND l.actualReturnDate is NULL",
                Loan.class);

        query.setParameter("membership", membership);

        return query.getResultList();
    }

    public List<Loan> findExpiredLoans() {
        TypedQuery<Loan> query = entityManager.createQuery(
                "SELECT l FROM Loan l WHERE l.actualReturnDate is NULL AND l.returnDateLimit < :today", Loan.class);

        query.setParameter("today", LocalDate.now());

        return query.getResultList();
    }
}
