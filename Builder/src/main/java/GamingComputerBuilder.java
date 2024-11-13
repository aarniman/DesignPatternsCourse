public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.buildComponent(new Component("Intel i9-14900K"));
    }

    @Override
    public void buildRAM() {
        computer.buildComponent(new Component("Corsair Vengeance LPX 16GB"));
        computer.buildComponent(new Component("Corsair Vengeance LPX 16GB"));
    }

    @Override
    public void buildHardDrive() {
        computer.buildComponent(new Component("Samsung 970 EVO Plus 1TB"));
        computer.buildComponent(new Component("WesternDigital Blue 7.2K RPM 2TB"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.buildComponent(new Component("Nvidia RTX 4090"));
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
