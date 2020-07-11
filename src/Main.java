import java.util.Scanner;

public class Main {

    static Library library = new Library();
    static Scanner userInput = new Scanner(System.in);
    static Boolean running = true;

    public static void main(String[] args) {

        System.out.print("\nWelcome to the Library management system.\n");

        do {
            System.out.println("Choose a number (e.g 0,1,2 etc) option to continue:\n");
            System.out.println("[0] ADD A BOOK");
            System.out.println("[1] ADD A CUSTOMER");
            System.out.println("[2] BOOKS LIST");
            System.out.println("[3] CUSTOMERS LIST");
            System.out.println("[4] RENT BOOK FOR CUSTOMER");
            System.out.println("[5] CUSTOMER RENTED BOOKS");
            System.out.println("[6] RETURN BOOK FROM CUSTOMER");
            System.out.println("[7] LOAD EXTERNAL DATA");
            System.out.println("[8] EXPORT LIBRARY JSON");
            System.out.println("[9] EXIT");
            System.out.println("[10] ADD A LIBRARIAN");

            int userOption = userInput.nextInt();
            userInput.nextLine();

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
                    library.listCustomers();
                    break;
                case 4:
                    rentBook();
                    break;
                case 5:
                    listCustomerBooks();
                    break;
                case 6:
                    returnBookFromCustomer();
                    break;
                case 7:
                    FileManager.readJSON(library);
                    break;
                case 8:
                    FileManager.exportJSON(library);
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                case 10:
                    addEmployerToLibrary();
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

        isbn = InputValidators.validateInt(
                userInput,
                "Enter the book ISBN",
                "Invalid input. Please use an integer bigger than 0."
        );

        title = InputValidators.validateString(
                userInput,
                "Enter the book title",
                "Invalid name. Please try again."
        );

        author = InputValidators.validateString(
                userInput,
                "Enter the book author",
                "Invalid name. Please try again."
        );

        Book newBook = new Book(isbn, title, author, false);
        library.addBook(newBook);
        System.out.println("New book added: \n" + newBook.toString());
    }

    private static void addCustomerToLibrary() {
        int id = library.getCustomers().size() + 1;

        String name = InputValidators.validateString(
                userInput,
                "Enter the customer name",
                "Invalid name. Please try again."
        );

        String address = InputValidators.validateString(
                userInput,
                "Enter the customer address",
                "Invalid address. Please try again."
        );

        int phone = InputValidators.validateInt(
                userInput,
                "Enter the customer phone number",
                "Invalid input. Please use only integers bigger than 0."
        );

        Customer newCustomer = new Customer(id, name, address, phone);
        library.addCustomer(newCustomer);
    }

    private static void addEmployerToLibrary() {
        int id = library.getLibrarians().size() + 1;

        String name = InputValidators.validateString(
                userInput,
                "Enter the librarian name",
                "Invalid name. Please try again."
        );

        String address = InputValidators.validateString(
                userInput,
                "Enter the librarian address",
                "Invalid address. Please try again."
        );

        int phone = InputValidators.validateInt(
                userInput,
                "Enter the librarian phone number",
                "Invalid input. Please use only integers bigger than 0."
        );

        int officeNumber = InputValidators.validateInt(
                userInput,
                "Enter the librarian office number",
                "Invalid input. Please use only integers bigger than 0."
        );

        Librarian newLibrarian = new Librarian(id, name, address, phone, officeNumber);
        library.addLibrarian(newLibrarian);
    }

    private static void rentBook() {
        int customerID, bookISBN;

        bookISBN = InputValidators.validateInt(
                userInput,
                "Enter the book ISBN",
                "Invalid input. Please use an integer bigger than 0."
        );

        customerID = InputValidators.validateInt(
                userInput,
                "Enter the customer ID",
                "Invalid input. Please use only integers bigger than 0."
        );

        Book book = library.findBookByISBN(bookISBN);
        Customer customer = library.findCustomerByID(customerID);

        library.setBookAsRented(book, true);
        library.rentBook(book, customer);
    }

    private static void listCustomerBooks() {
        int customerID;

        customerID = InputValidators.validateInt(
                userInput,
                "Enter the customer ID",
                "Invalid input. Please use an integer bigger than 0."
        );

        Customer customer = library.findCustomerByID(customerID);
        customer.listRentedBooks();
    }

    private static void returnBookFromCustomer() {
        int customerID, bookISBN;

        customerID = InputValidators.validateInt(
                userInput,
                "Enter the customer ID",
                "Invalid input. Please use an integer bigger than 0."
        );

        bookISBN = InputValidators.validateInt(
                userInput,
                "Enter the book ISBN",
                "Invalid input. Please use an integer bigger than 0."
        );

        Customer customer = library.findCustomerByID(customerID);
        customer.returnBook(bookISBN);
        Book book = library.findBookByISBN(bookISBN);
        library.setBookAsRented(book, false);
    }
}
