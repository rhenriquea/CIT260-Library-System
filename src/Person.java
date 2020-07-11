/**
 * Class to present a generic person.
 *
 * @author Alex Uskova
 * @author Rafael Almeida
 * @version 1.0
 */
public class Person {
    static int currentId = 0;       // This will be unique for every person, since it will be incremented when every time
    // a new person is created

    protected String name;          // Name of every person related to library
    protected String address;       // Address of every person related to library
    protected int phone;            // Phone of every person related to library
    private int id;                 // ID of every person related to library

    // A parameterized constructor inherited by the child classes
    public Person(int digit, String name, String address, int phone) {

        // If no digit increment current id otherwise use value passed to constructor
        if (digit == -1) {
            this.id = currentId++;
        } else {
            this.id = digit;
        }

        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // GETTERS

    /**
     * Gets the id from the person
     *
     * @return An int containing the id of the person
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the person.
     *
     * @param id An int to be used as the person id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name from the person
     *
     * @return A String containing the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name A String to be used as the name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    // SETTERS

    /**
     * Gets the address from the person
     *
     * @return A String containing the address of the person
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the person.
     *
     * @param address A String to be used as the address of the person.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number from the person
     *
     * @return A int containing the phone number of the person
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phone An int to be used as the phone number of the person.
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Prints the information of the person
     */
    public void getInfo() {
        System.out.print("\u001B[34m");
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }
}