import java.util.ArrayList;

/**
 * Class to represent a customer.
 * @author Alex Uskova
 * @author Rafael Almeida
 * @version 1.0
 */
public class Customer extends Person {
    private int id;                 // customerID as a single ID
    private String name;            // name as the customer name
    private ArrayList<Book> books;  // books as the list of rented books

    public Customer() {
        id = 0;
        name = null;
        books = new ArrayList<Book>();
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        books = new ArrayList<Book>();
    }

    // GETTERS

    public int getCustomerID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    // SETTERS

    public void setCustomerID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }


    public void rentBook(Book rentedBook) {
        this.books.add(rentedBook);
    }

    public void returnBook(int bookISBN) {
        books.removeIf(b -> b.getIsbn() == bookISBN);
    }

    public void listRentedBooks() {
        books.forEach(book -> System.out.print(
                name + " is renting " + book.getTitle() + " from the author " + book.getAuthor() + "\n"
        ));
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"customerID\": " + id + ", \n" +
                "  \"name\": \"" + name + "\", \n" +
                "  \"books\": " + books + " \n" +
                "}\n";
    }
}
