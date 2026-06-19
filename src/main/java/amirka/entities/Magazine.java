package amirka.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "magazines")
public class Magazine extends Catalog {
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    public Magazine() {
    }

    public Magazine(String isbn, String title, int publicationYear, int pages, List<Loan> loans, Frequency frequency) {
        super(isbn, title, publicationYear, pages, loans);
        this.frequency = frequency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "Magazine{" + super.toString() +
                "frequency=" + frequency +
                '}';
    }
}
