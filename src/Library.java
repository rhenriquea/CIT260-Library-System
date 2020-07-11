import java.util.ArrayList;

/**
 * Class to represent a library.
 *
 * @author Alex Uskova
 * @author Rafael Almeida
 * @version 1.0
 */
public class Library {
    private final ArrayList<Book> books;           // Books registered in the library
    private final ArrayList<Customer> customers;   // Customers registered in the library
    private final ArrayList<Librarian> librarians; // Librarians working in the library

    // A no-arg constructor that creates an empty library object.
    public Library() {
        books = new ArrayList<Book>();
        customers = new ArrayList<Customer>();
        librarians = new ArrayList<Librarian>();
    }

    // GETTERS

    /**
     * Gets the books registered in the library
     *
     * @return An Array list with Book objects.
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Gets the customers registered in the library
     *
     * @return An Array list with Customer objects.
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    /**
     * Gets the librarians working in the library
     *
     * @return An Array list with Librarian objects.
     */
    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    /**
     * Adds a book to the library reference
     *
     * @param book A Book object to be added to the library.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Adds a customer to the library reference
     *
     * @param customer A Customer object to be added to the library.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Adds a librarian to the library reference
     *
     * @param librarian A Librarian object to be added to the library.
     */
    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    /**
     * List all books registered in the library
     *
     * @return A print with the Book objects registered in the library
     */
    public void listBooks() {
        if (books.size() == 0) {
            System.out.println("\u001B[33m" + "No books registered." + "\u001B[0m");
        }
        books.forEach(book -> book.getInfo());
    }

    /**
     * List all customers registered in the library
     *
     * @return A print with the Customers objects registered in the library
     */
    public void listCustomers() {
        if (customers.size() == 0) {
            System.out.println("\u001B[33m" + "No customers registered." + "\u001B[0m");
        }
        customers.forEach(customer -> customer.getInfo());
    }

    /**
     * List all librarians registered in the library
     *
     * @return A print with the Librarian objects registered in the library
     */
    public void listLibrarians() {
        if (librarians.size() == 0) {
            System.out.println("\u001B[33m" + "No librarians registered." + "\u001B[0m");
        }
        librarians.forEach(librarian -> librarian.getInfo());
    }

    /**
     * Find a book in the library collection by its ISBN number
     *
     * @param bookISBN the ISBN from the Book that you want to find
     * @return A Book from the ISBN that was passed or null
     */
    public Book findBookByISBN(int bookISBN) {
        for (Book book : books) {
            if (book.getIsbn() == bookISBN) {
                return book;
            }
        }
        System.out.println("\u001B[33m" + "The book with ISBN " + bookISBN + " was not found." + "\u001B[0m");
        return null;
    }

    /**
     * Find a customer in the library collection by its id number
     *
     * @param customerID the ID from the Customer that you want to find
     * @return A Customer with the ID that was passed or null
     */
    public Customer findCustomerByID(int customerID) {
        for (Customer customer : customers) {
            if (customer.getId() == customerID) {
                return customer;
            }
        }
        System.out.println("\u001B[31m" + "The customer with ID " + customerID + " was not found." + "\u001B[0m");
        return null;
    }

    /**
     * Assign a book object to a customer
     *
     * @param book     the Book object that you want to assign to a customer
     * @param customer the Customer object that you want to assign the book
     */
    public void rentBook(Book book, Customer customer) {
        customer.rentBook(book);
        customer.listRentedBooks();
    }

    /**
     * Define the availability of the book in the library
     *
     * @param book   the Book object that you want to assign as rented
     * @param rented a boolean to indicate if it's rented or not
     */
    public void setBookAsRented(Book book, boolean rented) {
        Book rentedBook = books.get(books.indexOf(book));
        rentedBook.setRented(rented);
    }
}
