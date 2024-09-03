import java.util.ArrayList;
import java.util.List;

public class Department extends Component {

    private List<Component> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public double getSalary() {
        double total = 0;
        for(Component component : components){
            total += component.getSalary();
        }
        return total;
    }

    @Override
    public String toXML(int indentLevel) {
        String indent = getChild(indentLevel);
        StringBuilder xml = new StringBuilder(indent + "<Department name=\"" + name + "\">\n");
        for(Component component : components){
            xml.append(component.toXML(indentLevel + 1));
        }
        xml.append(indent + "</Department>\n");
        return xml.toString();
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String getChild(int i) {
        return null;
    }
}
