public class Librarian extends Person {
    int employeeID;
    public Librarian(String n, String a, int p, String ei)
    {
        super(n,a,p);
    }
    @Override
    public void Info()
    {
        super.Info();
        System.out.println("Office Number: " + employeeID);
    }
}