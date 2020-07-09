import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books;
    private final ArrayList<Customer> customers;

    public Library() {
        books = new ArrayList<Book>();
        customers = new ArrayList<Customer>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void listBooks() {
        if(books.size() == 0) {
            System.out.println("No books registered.");
        }
        books.forEach(book -> System.out.println(book));
    }

    public void listCustomers() {
        if(customers.size() == 0) {
            System.out.println("No customers registered.");
        }
        customers.forEach(customer -> System.out.println(customer));
    }

    public Book findBookByISBN(int bookISBN) {
        for (Book book : books) {
            if (book.getIsbn() == bookISBN) {
                return book;
            }
        }
        return null;
    }

    public Customer findCustomerByID(int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null;
    }

    public void rentBook(Book book, Customer customer) {
        customer.rentBook(book);
        customer.listRentedBooks();
    }

    public void setBookAsRented(Book book, boolean rented) {
        Book rentedBook = books.get(books.indexOf(book));
        rentedBook.setRented(rented);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
