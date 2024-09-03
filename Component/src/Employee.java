public class Employee extends Component{

    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toXML(int indentLevel) {
        String indent = getChild(indentLevel);
        return indent + "<Employee name=\"" + name + "\" salary=\"" + salary + "\" />\n";
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Not supported in a leaf node");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Not supported in a leaf node");
    }
}
