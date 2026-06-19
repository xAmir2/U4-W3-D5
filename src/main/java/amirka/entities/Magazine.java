package amirka.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "magazines")
public class Magazine extends Catalog {
    @Enumerated(EnumType.STRING)
    @Column(name = "frequency")
    private Frequency frequency;

    public Magazine() {
    }

    public Magazine(String isbn, String title, int publicationYear, int pages, Frequency frequency) {
        super(isbn, title, publicationYear, pages);
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
