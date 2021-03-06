import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Class to manage the import and export of a JSON file.
 *
 * @author Alex Uskova
 * @author Rafael Almeida
 * @version 1.0
 */
public class FileManager {

    // Name of the file to be exported and imported.
    static String filename = "library-data.json";

    /**
     * Exports a file called library-data.json based on a
     * Library instance
     *
     * @param library the Library instance to be exported
     */
    public static void exportJSON(Library library) {
        // Creates main library object
        JSONObject libraryJSON = new JSONObject();
        libraryJSON.put("Name", "CIT 260 - Final Java Project");
        libraryJSON.put("Last export", timestamp());

        JSONArray authors = new JSONArray();
        authors.add("Alex Uskova");
        authors.add("Rafael Almeida");
        libraryJSON.put("authors", authors);

        // Creates JSON arrays: books, customers and librarians
        JSONArray customersJSON = new JSONArray();
        JSONArray booksJSON = new JSONArray();
        JSONArray librariansJSON = new JSONArray();

        // Adds arrays lists from the library instance to the JSON array
        customersJSON.addAll(library.getCustomers());
        booksJSON.addAll(library.getBooks());
        librariansJSON.addAll(library.getLibrarians());

        // Adds JSON arrays to the main library JSON object
        libraryJSON.put("books", booksJSON);
        libraryJSON.put("customers", customersJSON);
        libraryJSON.put("librarians", librariansJSON);

        // Tries to create the file, otherwise, throws an error
        try (FileWriter file = new FileWriter(filename)) {
            file.write(libraryJSON.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads or create the library-data.json file and assign it's properties to a
     * Library instance
     *
     * @param library the Library instance to be filled from the parsed JSON
     */
    public static void readJSON(Library library) {
        // Creates an instance from the JSON parser
        JSONParser parser = new JSONParser();
        // Creates an instance of a file object
        File file = new File(filename);

        // Check if files exists, otherwise, create one
        if (file.exists()) {
            try {
                // Parses the file as an Object
                Object obj = parser.parse(new FileReader(filename));

                // Casts the Object to a JSONObject
                JSONObject jsonData = (JSONObject) obj;

                // Get the JSON array from the property books
                JSONArray books = (JSONArray) jsonData.get("books");

                // Parse each JSON book reference to the library
                books.forEach(book -> parseBookToLibrary((JSONObject) book, library));

                // Get the JSON array from the property customers
                JSONArray customers = (JSONArray) jsonData.get("customers");
                // Parse each JSON customer reference to the library
                customers.forEach(customer -> parseCustomerToLibrary((JSONObject) customer, library));

                // Get the JSON array from the property librarians
                JSONArray librarians = (JSONArray) jsonData.get("librarians");
                // Parse each JSON librarian reference to the library
                librarians.forEach(librarian -> parseLibrarianToLibrary((JSONObject) librarian, library));

                // Print message of feedback for the user.
                System.out.println("\u001B[36m" + "Information Loaded from JSON file." + "\u001B[0m");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            // Print message of feedback for the user.
            System.out.println("\u001B[33m" + "File not found. Creating a new file." + "\u001B[0m");
            // Export a JSON based on the library reference
            exportJSON(library);
        }
    }

    /**
     * Parse a book JSON Object and add the books array list in a instance of the library
     *
     * @param jsonBook the single element of JSONObject stored in the JSON array
     * @param library  the Library instance to be filled from the parsed JSON
     */
    private static void parseBookToLibrary(JSONObject jsonBook, Library library) {
        // Cast isbn from JSON as long and store in the variable
        long isbn = (long) jsonBook.get("isbn");
        // Cast author from JSON as String and store in the variable
        String author = (String) jsonBook.get("author");
        // Cast title from JSON as String and store in the variable
        String title = (String) jsonBook.get("title");
        // Cast rented from JSON as boolean and store in the variable
        boolean rented = (boolean) jsonBook.get("rented");
        // Create a new Object instance with the JSON information
        Book record = new Book((int) isbn, title, author, rented);
        // Add the Book instance to the library instance
        library.addBook(record);
    }

    /**
     * Parse a customer JSON Object and add the customers array list in a instance of the library
     *
     * @param jsonCustomer the single element of JSONObject stored in the JSON array
     * @param library      the Library instance to be filled from the parsed JSON
     */
    private static void parseCustomerToLibrary(JSONObject jsonCustomer, Library library) {

        // Cast customerID from JSON as long and store in the variable
        long customerID = (long) jsonCustomer.get("customerID");
        // Cast customer name from JSON as String and store in the variable
        String name = (String) jsonCustomer.get("name");
        // Cast customer address from JSON as String and store in the variable
        String address = (String) jsonCustomer.get("address");
        // Cast customer phone from JSON as String, parse as int and store in the variable
        int phone = Integer.parseInt((String) jsonCustomer.get("phone"));

        // Create a new Object instance with the JSON information
        Customer record = new Customer((int) customerID, name, address, (int) phone);

        // Cast books array from JSON as ArrayList of Book and store in the variable
        JSONArray booksJSON = (JSONArray) jsonCustomer.get("books");
        booksJSON.forEach(book ->  parseCustomerBooks((JSONObject) book, record));

        // Add the Customer instance to the library instance
        library.addCustomer(record);
    }

    /**
     * Parse a book JSON Object and add to the rented books by the customer
     *
     * @param jsonBook the single element of JSONObject stored in the JSON array
     * @param customer the Customer instance to be filled with the parsed JSON
     */
    private static void parseCustomerBooks(JSONObject jsonBook, Customer customer) {
        // Cast isbn from JSON as long and store in the variable
        long isbn = (long) jsonBook.get("isbn");
        // Cast author from JSON as String and store in the variable
        String author = (String) jsonBook.get("author");
        // Cast title from JSON as String and store in the variable
        String title = (String) jsonBook.get("title");
        // Cast rented from JSON as boolean and store in the variable
        boolean rented = (boolean) jsonBook.get("rented");
        // Create a new Object instance with the JSON information
        Book rentedBook = new Book((int) isbn, title, author, rented);
        customer.rentBook(rentedBook);
    }

    /**
     * Parse a librarian JSON Object and add it to librarians array list in a instance of the library
     *
     * @param jsonLibrarian the single element of JSONObject stored in the JSON array
     * @param library      the Library instance to be filled from the parsed JSON
     */
    private static void parseLibrarianToLibrary(JSONObject jsonLibrarian, Library library) {
        // Cast librarianID from JSON as long and store in the variable
        long librarianID = (long) jsonLibrarian.get("librarianID");
        // Cast librarian name from JSON as String and store in the variable
        String name = (String) jsonLibrarian.get("name");
        // Cast librarian address from JSON as String and store in the variable
        String address = (String) jsonLibrarian.get("address");
        // Cast librarian phone from JSON as String, parse as int and store in the variable
        int phone = Integer.parseInt((String) jsonLibrarian.get("phone"));
        // Cast librarian office number from JSON as int and store in the variable
        long officeNumber = (long) jsonLibrarian.get("officeNumber");
        // Create a new Object instance with the JSON information
        Librarian record = new Librarian((int) librarianID, name, address, (int) phone, (int) officeNumber);
        // Add the Librarian instance to the library instance
        library.addLibrarian(record);
    }

    /**
     * Helper to get current timestamp
     *
     * @return Returns a String formatted as ISO 8601 of the current time
     */
    private static String timestamp() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // No timezone offset
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(new Date());
    }
}
