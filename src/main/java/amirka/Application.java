package amirka;

import amirka.dao.CatalogDAO;
import amirka.dao.LoanDAO;
import amirka.dao.UserDAO;
import amirka.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        CatalogDAO catalogDAO = new CatalogDAO(em);
        UserDAO userDAO = new UserDAO(em);
        LoanDAO loanDAO = new LoanDAO(em);

        Book b1 = new Book("1a2b3c", "Harry Potter and the Philosopher's Stone", 1997, 223, "J.K. Rowling",
                "Fantasy");
        Book b2 = new Book("123456", "Harry Potter and the Chamber of Secrets", 1998, 251, "J.K. Rowling",
                "Fantasy");
        Book b3 = new Book("523523", "Harry Potter and the Prisoner of Azkaban", 1999, 317, "J.K. Rowling",
                "Fantasy");
        Book b4 = new Book("5r235235", "Harry Potter and the Goblet of Fire", 2000, 636, "J.K. Rowling",
                "Fantasy");
        Book b5 = new Book("97801323", "Clean Code", 2008, 464, "Robert C. Martin",
                "Programming");
        Book b6 = new Book("97802016", "Design Patterns", 1994, 395, "Erich Gamma",
                "Software Engineering");
        Book b7 = new Book("97801346", "Effective Java", 2018, 416, "Joshua Bloch",
                "Programming");
        Book b8 = new Book("97816145", "Spring in Action", 2018, 520, "Craig Walls",
                "Programming");

        Magazine m1 = new Magazine("5255325", "National Geographic", 2026, 120, Frequency.MONTHLY);

        Magazine m2 = new Magazine("5474574", "Time", 2026, 90, Frequency.WEEKLY);

        Magazine m3 = new Magazine("88645732", "Science Today", 2026, 150, Frequency.SEMIANNUAL);

        Magazine m4 = new Magazine("45747822", "Tech World", 2026, 110, Frequency.MONTHLY);

        Magazine m5 = new Magazine("645745778", "Forbes", 2026, 85, Frequency.MONTHLY);

        Magazine m6 = new Magazine("458432577", "The Economist", 2026, 95, Frequency.WEEKLY);

        Magazine m7 = new Magazine("745745767", "Nature Review", 2025, 140, Frequency.SEMIANNUAL);

        Magazine m8 = new Magazine("7847343422", "PC Magazine", 2026, 100, Frequency.MONTHLY);

        Magazine test = new Magazine("test-delete", "Going to be deleted", 2026, 1, Frequency.WEEKLY);

        User u1 = new User("Mario", "Rossi", LocalDate.of(1995, 5, 12), "MEMBER1");

        User u2 = new User("Giulia", "Bianchi", LocalDate.of(1998, 8, 20), "MEMBER2");

        User u3 = new User("Luca", "Verdi", LocalDate.of(1992, 1, 7), "MEMBER3");

        User u4 = new User("Sara", "Neri", LocalDate.of(2000, 11, 15), "MEMBER4");


        Loan l1 = new Loan(u1, b1, LocalDate.now(), LocalDate.now()
                .plusDays(30), null);
        Loan l2 = new Loan(u2, b2, LocalDate.now()
                .minusDays(20), LocalDate.now()
                .plusDays(10), LocalDate.now());
        Loan l3 = new Loan(u1, m4, LocalDate.now(), LocalDate.now()
                .minusDays(40)
                .minusDays(10), null);
        Loan l4 = new Loan(u4, b5, LocalDate.now()
                .minusDays(50), LocalDate.now()
                .minusDays(20), null);

        //catalogDAO.save(b1);
        //catalogDAO.save(b2);
        //catalogDAO.save(b3);
        //catalogDAO.save(b4);
        //catalogDAO.save(b5);
        //catalogDAO.save(b6);
        //catalogDAO.save(b7);
        //catalogDAO.save(b8);

        //catalogDAO.save(m1);
        //catalogDAO.save(m2);
        //catalogDAO.save(m3);
        //catalogDAO.save(m4);
        //catalogDAO.save(m5);
        //catalogDAO.save(m6);
        //catalogDAO.save(m7);
        //catalogDAO.save(m8);

        //userDAO.save(u1);
        //userDAO.save(u2);
        //userDAO.save(u3);
        //userDAO.save(u4);

        //loanDAO.save(l1);
        //loanDAO.save(l2);
        //loanDAO.save(l3);
        //loanDAO.save(l4);

        //Adding Magazine 
        //catalogDAO.save(test);

        // Finding catalog using isbn
        System.out.println("\n" + catalogDAO.findByIsbn("5255325"));

        // Successful print! Now let's delete it
        // catalogDAO.deleteUsingIsbn("test-delete");
        // System.out.println(catalogDAO.findByIsbn("test-delete"));

        // Catalog was successfully deleted. Now let's attempt a search by year of release.
        System.out.println("\n" + catalogDAO.findByYear(1999));

        // One book was found: [Book{Catalog{id=258c64fa-074e-4257-8c04-41472abff798, isbn='523523', title='Harry Potter and the Prisoner of Azkaban', publicationYear=1999, pages=317}author='J.K. Rowling', genre='Fantasy'}]

        // Now let's attempt a search using the Author's name
        System.out.println("\n" + catalogDAO.findByAuthor("Joshua Bloch"));
        // One book was found: [Book{Catalog{id=4e2b246d-fbd0-453a-87dc-4d64fea91f12, isbn='97801346', title='Effective Java', publicationYear=2018, pages=416}author='Joshua Bloch', genre='Programming'}]

        // Now let's attempt a search using book title or part of it
        System.out.println("\n" + catalogDAO.fingByTitle("Harry Potter"));
        // Four books were found: [Book{Catalog{id=f67405ec-a2a2-4106-b52d-61afb90d6ecc, isbn='1a2b3c', title='Harry Potter and the Philosopher's Stone', publicationYear=1997, pages=223}author='J.K. Rowling', genre='Fantasy'}, Book{Catalog{id=02b38c57-6814-4e4f-a71a-01e00820792c, isbn='123456', title='Harry Potter and the Chamber of Secrets', publicationYear=1998, pages=251}author='J.K. Rowling', genre='Fantasy'}, Book{Catalog{id=258c64fa-074e-4257-8c04-41472abff798, isbn='523523', title='Harry Potter and the Prisoner of Azkaban', publicationYear=1999, pages=317}author='J.K. Rowling', genre='Fantasy'}, Book{Catalog{id=db457c6c-2617-44db-bf4a-d53b77524300, isbn='5r235235', title='Harry Potter and the Goblet of Fire', publicationYear=2000, pages=636}author='J.K. Rowling', genre='Fantasy'}]

        //Now let's attempt to find if there is a current loan using membership card
        System.out.println("\n" + loanDAO.findCurrentlyInLoans("MEMBER1"));
        //Found 2 loans and one is overdue: [Loan{id=24a2b52f-966d-4887-b69e-56127a47c91b, loanDate=2026-06-19, returnDateLimit=2026-07-19, actualReturnDate=null}, Loan{id=e4afb7b0-ffcd-431f-a602-d2b3b2932602, loanDate=2026-06-19, returnDateLimit=2026-04-30, actualReturnDate=null}]

        //Now let's attempt to find overdue returns
        System.out.println("\n" + loanDAO.findExpiredLoans());
        //Found 2 overdue returns: [Loan{id=e4afb7b0-ffcd-431f-a602-d2b3b2932602, loanDate=2026-06-19, returnDateLimit=2026-04-30, actualReturnDate=null}, Loan{id=1e5fc82f-bf82-491e-9458-15618523f55e, loanDate=2026-04-30, returnDateLimit=2026-05-30, actualReturnDate=null}]

    }
}
