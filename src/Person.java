public class Person {
    private int id;
    private String name;
    private String address;
    private int phone;

    public Person() {
        name = null;
        address = null;
        phone = 0;
    }

    public Person(String n, String a, int p) {
        name = n;
        address = a;
        phone = p;
    }

    public void Info() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }

    public void setPhone(int p) {
        phone = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        address = a;
    }

    public int getPhoneNumber() {
        return phone;
    }


}