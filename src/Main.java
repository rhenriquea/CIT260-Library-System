import java.util.Scanner;

public class Main {

    static Library library = new Library();
    static Scanner userInput = new Scanner(System.in);
    static Boolean running = true;
    static String successMessage = "";

    public static void main(String[] args) {

        System.out.print("\nWelcome to the Library management system.\n");

        do  {
            if(!successMessage.isBlank()) {
                System.out.println(successMessage);
                successMessage = "";
            }
            System.out.println("Choose a number (e.g 0,1,2 etc) option to continue:\n");
            System.out.println("[0] ADD A BOOK");
            System.out.println("[1] ADD A CUSTOMER");
            System.out.println("[2] BOOKS LIST");
            System.out.println("[3] RENT BOOK FOR CUSTOMER");
            System.out.println("[4] RETURN BOOK FROM CUSTOMER");
            System.out.println("[5] CUSTOMER RENTED BOOKS");
            System.out.println("[6] CUSTOMERS LIST");
            System.out.println("[7] EXIT");

            int userOption = userInput.nextInt();

            switch (userOption) {
                case 0:
                    addBookToLibrary();
                    break;
                case 1:
                    addCustomerToLibrary();
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 3:
                    rentBook();
                    break;
                case 4:
                    returnBookFromCustomer();
                    break;
                case 5:
                    listCustomerBooks();
                    break;
                case 6:
                    library.listCustomers();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (running);
    }

    private static void addBookToLibrary() {
        int isbn;             // ISBN as ID from the Book
        String title, author; // Title and Author of the book

        System.out.println("\nEnter the book ISBN:");
        isbn = userInput.nextInt();

        System.out.println("\nEnter the book title:");
        title = userInput.next();

        System.out.println("\nEnter the book author:");
        author = userInput.next();

        Book newBook = new Book(isbn, title, author, false);
        library.addBook(newBook);
        successMessage = "New book added: \n" + newBook.toString();
    }

    private static void addCustomerToLibrary() {
        String name;

        System.out.println("\nEnter the customer name:");
        name = userInput.next();

        Customer newCustomer = new Customer(1, name);
        library.addCustomer(newCustomer);
    }

    private static void rentBook() {
        int renterId, bookISBN;

        System.out.println("\nEnter the book ISBN:");
        bookISBN = userInput.nextInt();

        System.out.println("\nEnter the renter ID:");
        renterId = userInput.nextInt();

        Book book = library.findBookByISBN(bookISBN);
        Customer customer = library.findCustomerByID(renterId);
        library.setBookAsRented(book, true);
        library.rentBook(book, customer);
    }

    private static void listCustomerBooks() {
        int renterId;
        System.out.println("\nEnter the renter ID:");
        renterId = userInput.nextInt();

        Customer customer = library.findCustomerByID(renterId);
        customer.listRentedBooks();
    }

    private static void returnBookFromCustomer() {
        int renterId, bookISBN;
        System.out.println("\nEnter the renter ID:");
        renterId = userInput.nextInt();

        System.out.println("\nEnter the book ISBN:");
        bookISBN = userInput.nextInt();

        Customer customer = library.findCustomerByID(renterId);
        customer.returnBook(bookISBN);
        Book book = library.findBookByISBN(bookISBN);
        library.setBookAsRented(book, false);
    }

}
