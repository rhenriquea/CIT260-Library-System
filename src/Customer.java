import java.util.ArrayList;

public class Customer {
    private int renterID;
    private String name;
    private ArrayList<Book> books;

    public Customer() {
        renterID = 0;
        name = null;
        books = new ArrayList<Book>();
    }

    public Customer(int renterID, String name) {
        this.renterID = renterID;
        this.name = name;
        books = new ArrayList<Book>();
    }

    public int getRenterID() {
        return renterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void rentBook(Book rentedBook) {
        this.books.add(rentedBook);
    }

    public void returnBook(int bookISBN) {
        books.removeIf(b -> b.getIsbn() == bookISBN);
    }

    public void listRentedBooks() {
        books.forEach(b -> System.out.println(this.name + " is now renting " + b.getTitle()));
    }

    @Override
    public String toString() {
        return "Renter{" +
                "renterID=" + renterID +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
