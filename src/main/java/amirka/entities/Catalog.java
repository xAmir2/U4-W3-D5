package amirka.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "catalog")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalog {
    @Id
    @GeneratedValue
    @Column(name = "catalog_id")
    private UUID id;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @Column(name = "pages", nullable = false)
    private int pages;

    @OneToMany(mappedBy = "catalog")
    private List<Loan> loans = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(String isbn, String title, int publicationYear, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pages = pages;
    }

    public UUID getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                '}';
    }
}
