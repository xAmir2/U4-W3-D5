Project Choices

I chose the JOINED inheritance strategy because I wanted to keep the DB clean, and it was the best choice in this case.

Between User and Loan, I implemented a bidirectional relationship.

On the Loan side, I used @ManyToOne because each loan can be assigned to only one user. 

Meanwhile, on the User side, I used @OneToMany because a single user can have multiple active loans at the same time and
can borrow several books/magazines.

The same I decided to use between Catalog and Loan a bidirectional OneToMany/ManyToOne relationship.

On the Loan side, I used @ManyToOne because each loan refers to a single catalog item at a time, whether it is a book or
a magazine.

On the Catalog side I used @OneToMany because the same catalog can be borrowed multiple times. A book or a magazine can
be borrowed, returned. and later borrowed again through a new loan.

I choose to use UUIDs as primary keys for all main entities to ensure unique identifiers and avoid relying on sequential
IDs.

I also added unique constraints on membershipNumber and isbn:
- Membership to uniquely identify each library members;
- isbn to uniquely identify each catalog item;

To keep project organized I implemented DAO pattern. Each entity has its own DAO responsible for interactions with the
DB and executing queries.
