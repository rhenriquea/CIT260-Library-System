/**
 * Class to represent a library employee (librarian).
 *
 * @author Alex Uskova
 * @author Rafael Almeida
 * @version 1.0
 */
public class Librarian extends Person {
    int officeNumber;  // Office number that the librarian will work

    // A parameterized constructor that creates a librarian object.
    public Librarian(int id, String name, String address, int phone, int officeNumber) {
        super(id, name, address, phone);
        this.officeNumber = officeNumber;
    }

    @Override
    public String toString() {
        // Format the book class and print as a string in a JSON format
        return "{\n" +
                "  \"librarianID\": " + this.getId() + ", \n" +
                "  \"name\": \"" + name + "\", \n" +
                "  \"address\": \"" + address + "\", \n" +
                "  \"phone\": \"" + phone + "\", \n" +
                "  \"officeNumber\": " + officeNumber + " \n" +
                "}\n";
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Office Number: " + officeNumber);
        System.out.print("\u001B[0m");
    }
}