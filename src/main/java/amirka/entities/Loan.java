package amirka.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog;

    @Column(name = "loan_date")
    private LocalDate loanDate;

    @Column(name = "return_date_limit")
    private LocalDate returnDateLimit;

    @Column(name = "actual_return_date")
    private LocalDate actualReturnDate;

    public Loan() {
    }

    public Loan(User user, Catalog catalog, LocalDate loanDate, LocalDate returnDateLimit, LocalDate actualReturnDate) {
        this.user = user;
        this.catalog = catalog;
        this.loanDate = loanDate;
        this.returnDateLimit = returnDateLimit;
        this.actualReturnDate = actualReturnDate;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User u1) {
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDateLimit() {
        return returnDateLimit;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanDate=" + loanDate +
                ", returnDateLimit=" + returnDateLimit +
                ", actualReturnDate=" + actualReturnDate +
                '}';
    }
}
