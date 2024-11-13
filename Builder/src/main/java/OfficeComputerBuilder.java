public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.buildComponent(new Component("Intel Core i3-10100f"));
    }

    @Override
    public void buildRAM() {
        computer.buildComponent(new Component("8GB"));
    }

    @Override
    public void buildHardDrive() {
        computer.buildComponent(new Component("1TB"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.buildComponent(new Component("Integrated Graphics"));
    }

    @Override
    public void buildOS() {
        computer.buildComponent(new Component("Windows 10"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
