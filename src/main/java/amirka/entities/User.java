package amirka.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(unique = true)
    private String membershipNumber;

    @OneToMany(mappedBy = "user")
    private List<Loan> loans = new ArrayList<>();

    public User() {
    }

    public User(String name, String surname, LocalDate birthDate, String membershipNumber) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.membershipNumber = membershipNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", membershipNumber='" + membershipNumber + '\'' +
                '}';
    }
}
