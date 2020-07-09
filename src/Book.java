import org.json.simple.JSONObject;

public class Book {
    private int isbn;             // ISBN as ID from the Book
    private String title, author; // Title and Author of the book
    private boolean rented;

    public Book() {
        isbn = 0;
        title = null;
        author = null;
        rented = false;
    }

    public Book(int isbn, String title, String author, boolean rented) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.rented = rented;
    }

    public JSONObject toJSON() {
        JSONObject bookJSON = new JSONObject();
        bookJSON.put("ISBN", this.isbn );
        bookJSON.put("title", this.title );
        bookJSON.put("author", this.title );
        bookJSON.put("rented", this.rented);
        return bookJSON;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Book{\n" +
                "  isbn=" + isbn + ", \n" +
                "  title='" + title + "', \n" +
                "  author='" + author + "', \n" +
                "  rented=" + rented + ", \n" +
                "}\n";
    }
}
