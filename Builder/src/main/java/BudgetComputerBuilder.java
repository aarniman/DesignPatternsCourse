public class BudgetComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public BudgetComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.buildComponent(new Component("Intel i5-12400f"));
    }

    @Override
    public void buildRAM() {
        computer.buildComponent(new Component("16GB"));
    }

    @Override
    public void buildHardDrive() {
        computer.buildComponent(new Component("Samsung 970 EVO Plus 1TB"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.buildComponent(new Component("RTX 3050"));
    }

    @Override
    public void buildOS() {
        computer.buildComponent(new Component("Windows 11"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
