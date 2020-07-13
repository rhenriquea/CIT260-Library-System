import java.util.ArrayList;

/**
 * Class to represent a customer.
 *
 * @author Alex Uskova
 * @author Rafael Almeida
 * @version 1.0
 */
public class Customer extends Person {
    private ArrayList<Book> books = new ArrayList<Book>();  // books as the list of rented books

    // A parameterized constructor that creates a customer object.
    public Customer(int id, String name, String address, int phone) {
        super(id, name, address, phone);
    }

    // GETTERS
    /**
     * Gets the customer rented books
     *
     * @return An array of books rented by the customer.
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    // SETTERS

    /**
     * Sets the customer books.
     *
     * @param books An ArraList<Book> containing the customer rented books.
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    // METHODS

    /**
     * Add a book to user rented books collection
     *
     * @param book A Book to be added to the customer rented books.
     */
    public void rentBook(Book book) {
        this.books.add(book);
    }

    /**
     * Removes book from customer rented books collection
     *
     * @param bookISBN A int containing the ISBN to be removed from the collection.
     */
    public void returnBook(int bookISBN) {
        for (Book book : books) {
            if (book.getIsbn() == bookISBN) {
                books.removeIf(b -> b.getIsbn() == bookISBN);
                return;
            }
        }
        System.out.print("\u001B[31m" + "Customer does not have any book with ISBN " + bookISBN + "\u001B[0m");
    }

    /**
     * Prints a message saying which books are in the customer rented books array.
     */
    public void listRentedBooks() {
        if(books.size() == 0) {
            System.out.print("\u001B[31m" + "Customer does not have any book rented" + "\u001B[0m");
            return;
        }

        books.forEach(book -> System.out.print(
                "\u001B[32m" +
                name + " is now renting " + book.getTitle() + " from the author " + book.getAuthor() + "\n" +
                "\u001B[0m"
        ));
    }

    @Override
    public String toString() {
        // Format the book class and print as a string in a JSON format
        return "{\n" +
                "  \"customerID\": " + this.getId() + ", \n" +
                "  \"name\": \"" + name + "\", \n" +
                "  \"address\": \"" + address + "\", \n" +
                "  \"phone\": \"" + phone + "\", \n" +
                "  \"books\": " + books + " \n" +
                "}\n";
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Books: " + books);
        System.out.print("\u001B[0m");
    }
}
