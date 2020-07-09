import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name;
    private ArrayList<Book> books;

    public Customer() {
        customerID = 0;
        name = null;
        books = new ArrayList<Book>();
    }

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        books = new ArrayList<Book>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
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
                name + "is renting" + book.getTitle() + " from the author " + book.getAuthor() + "\n"
        ));
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"customerID\": " + customerID + ", \n" +
                "  \"name\": \"" + name + "\", \n" +
                "  \"books\": " + books + " \n" +
                "}\n";
    }
}
