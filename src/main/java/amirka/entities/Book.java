package amirka.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "books")
public class Book extends Catalog {
    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    public Book() {
    }

    public Book(String isbn, String title, int publicationYear, int pages, List<Loan> loans, String author, String genre) {
        super(isbn, title, publicationYear, pages, loans);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
