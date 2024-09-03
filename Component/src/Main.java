public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("John Doe", 20000);
        Employee e2 = new Employee("Jane Doe", 25000);
        Employee e3 = new Employee("Mary Jane", 30000);

        Department sales = new Department("Sales");
        sales.add(e1);
        sales.add(e2);

        Department headOffice = new Department("Head Office");
        headOffice.add(sales);
        headOffice.add(e3);

        System.out.println("Total salary: " + headOffice.getSalary());

        System.out.println(headOffice.toXML(0));
    }
}