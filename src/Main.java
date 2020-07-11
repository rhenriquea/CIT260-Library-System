import java.util.Scanner;

public class Main {

    static Library library = new Library();
    static Scanner userInput = new Scanner(System.in);
    static Boolean welcomeMenuRunning = true;
    static Boolean adminMenuRunning = false;
    static Boolean customerMenuRunning = false;

    public static void main(String[] args) {

        menuHeadline("Welcome to the Library management system");

        do {
            System.out.println("Choose an option:\n");
            System.out.println("[1] LOGIN AS ADMIN");
            System.out.println("[2] LOGIN AS CUSTOMER");
            System.out.println("[3] EXIT");

            int userOption = userInput.nextInt();
            userInput.nextLine();

            switch (userOption) {
                case 1:
                    welcomeMenuRunning = false;
                    adminMenuRunning = true;
                    runAdminMenu();
                    break;
                case 2:
                    welcomeMenuRunning = false;
                    customerMenuRunning = true;
                    runCustomerMenu();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid Option.");
                    break;
            }

        } while (welcomeMenuRunning);
    }


    private static void runAdminMenu() {

        menuHeadline("Admin Main Menu");

        do {
            System.out.println("\nChoose a number (e.g 0,1,2 etc) option to continue:\n");
            System.out.println("[1] ADD A BOOK");
            System.out.println("[2] ADD A CUSTOMER");
            System.out.println("[3] ADD A LIBRARIAN");
            System.out.println("[4] BOOKS LIST");
            System.out.println("[5] CUSTOMERS LIST");
            System.out.println("[6] EMPLOYEES LIST");
            System.out.println("[7] CUSTOMER RENTED BOOKS");
            System.out.println("[8] RETURN BOOK FROM CUSTOMER");
            System.out.println("[9] LOAD EXTERNAL DATA");
            System.out.println("[0] EXPORT JSON FILE");
            System.out.println("[10] BACK TO MAIN MENU");
            System.out.println("[11] EXIT (WITHOUT SAVE)");

            int userOption = userInput.nextInt();
            userInput.nextLine();

            switch (userOption) {
                case 1:
                    addBookToLibrary();
                    break;
                case 2:
                    addCustomerToLibrary();
                    break;
                case 3:
                    addEmployerToLibrary();
                    break;
                case 4:
                    library.listBooks();
                    break;
                case 5:
                    library.listCustomers();
                    break;
                case 6:
                    library.listLibrarians();
                    break;
                case 7:
                    listCustomerBooks();
                    break;
                case 8:
                    returnBookFromCustomer();
                    break;
                case 9:
                    FileManager.readJSON(library);
                    break;
                case 0:
                    FileManager.exportJSON(library);
                    break;
                case 10:
                    welcomeMenuRunning = true;
                    adminMenuRunning = false;
                    break;
                case 11:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (adminMenuRunning);
    }

    private static void runCustomerMenu() {
        menuHeadline("Customer Main Menu");

        do {
            System.out.println("Choose a number (e.g 0,1,2 etc) option to continue:\n");
            System.out.println("[1] LIST ALL BOOKS");
            System.out.println("[2] RENT A BOOK");
            System.out.println("[3] BACK TO MAIN MENU");
            System.out.println("[4] EXIT");

            int userOption = userInput.nextInt();
            userInput.nextLine();

            switch (userOption) {
                case 1:
                    library.listBooks();
                    break;
                case 2:
                    rentBook();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                case 3:
                    welcomeMenuRunning = true;
                    customerMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (customerMenuRunning);
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

        // Change color of the console to highlight the success
        System.out.print("\u001B[32m");
        System.out.println("New book added:");
        newBook.getInfo();
        // Back to original color
        System.out.print("\u001B[0m");
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

        // Change color of the console to highlight the success
        System.out.print("\u001B[32m");
        System.out.println("New customer added:");
        // Back to original color
        System.out.print("\u001B[0m");
        newCustomer.getInfo();

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

        // Change color of the console to highlight the success
        System.out.print("\u001B[32m");
        System.out.println("New librarian added:");
        newLibrarian.getInfo();
        // Back to original color
        System.out.print("\u001B[0m");
    }

    private static void rentBook() {
        int customerID, bookISBN;

        if(library.getBooks().size() == 0) {
            System.out.println("Sorry, there are no books registered at this time. " +
                    "Ask for the library employee help.");
            return;
        }

        bookISBN = InputValidators.validateInt(
                userInput,
                "Enter the book ISBN",
                "Invalid input. Please use an integer bigger than 0."
        );

        Book book = library.findBookByISBN(bookISBN);

        if(book.isRented()) {
            System.out.print("\u001B[33m");
            System.out.println("Sorry, this books is already rented by someone else");
            System.out.print("\u001B[0m");
            return;
        }

        customerID = InputValidators.validateInt(
                userInput,
                "Enter your customer ID. If You don't know the number, ask a librarian to help you.",
                "Invalid input. Please use only integers bigger than 0."
        );


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

        Customer customer = library.findCustomerByID(customerID);

        if (customer.getBooks().size() == 0) {
            System.out.print("\u001B[31m" + "Customer does not have any book rented" + "\u001B[0m");
            return;
        }

        bookISBN = InputValidators.validateInt(
                userInput,
                "Enter the book ISBN",
                "Invalid input. Please use an integer bigger than 0."
        );


        customer.returnBook(bookISBN);
        Book book = library.findBookByISBN(bookISBN);
        library.setBookAsRented(book, false);

        System.out.print("\u001B[32m");
        System.out.print(customer.getName() + " returned " + book.getTitle());
        System.out.print("\u001B[0m");
    }

    private static void menuHeadline(String title) {
        System.out.print("\u001b[31;96m");
        System.out.println("--------------------------------------------------------");
        System.out.println("\t" + title);
        System.out.println("--------------------------------------------------------");
        System.out.print("\u001B[0m");
    }
}
