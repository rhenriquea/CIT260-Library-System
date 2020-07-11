/**
 * Class to represent a book.
 *
 * @author Alex Uskova
 * @author Rafael Almeida
 * @version 1.0
 */
public class Book {
    private int isbn;             // ISBN as ID from the Book
    private String title, author; // Title and Author of the book
    private boolean rented;       // Define the availability of the book

    // A no-arg constructor that creates an empty book object.
    public Book() {
        isbn = 0;
        title = null;
        author = null;
        rented = false;
    }

    // A parameterized constructor that creates a book object.
    public Book(int isbn, String title, String author, boolean rented) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.rented = rented;
    }

    // GETTERS

    /**
     * Gets the book ISBN
     *
     * @return An int representing the book ISBN.
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * Sets the book ISBN.
     *
     * @param isbn An int containing the ISBN number.
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the book title
     *
     * @return A String representing the book title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the book title.
     *
     * @param title A String containing the book title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    // SETTERS

    /**
     * Gets the book author
     *
     * @return A String representing the book author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the book author.
     *
     * @param author A String containing the book author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the book rented status
     *
     * @return A boolean representing the rental status of the book.
     */
    public boolean isRented() {
        return rented;
    }

    /**
     * Sets the book rental availability status.
     *
     * @param rented A boolean indicating if the book is rented or not.
     */
    public void setRented(boolean rented) {
        this.rented = rented;
    }


    /**
     * Prints the information of the person
     */
    public void getInfo() {
        System.out.print("\u001B[34m");
        System.out.println("\nISBN: " + isbn);
        System.out.println("Name: " + title);
        System.out.println("Author: " + author);
        System.out.println("Is available: " + !rented);
        System.out.print("\u001B[0m");
    }

    @Override
    public String toString() {
        // Format the book class and print as a string in a JSON format
        return "{\n" +
                "  \"isbn\": " + isbn + ", \n" +
                "  \"title\": \"" + title + "\", \n" +
                "  \"author\": \"" + author + "\", \n" +
                "  \"rented\": " + rented + " \n" +
                "}\n";
    }


}
