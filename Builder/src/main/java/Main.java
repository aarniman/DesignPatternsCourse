import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the type of computer you want to build: ");
        System.out.println("1. Gaming Computer");
        System.out.println("2. Office Computer");
        System.out.println("3. Budget Computer");
        int choice = scanner.nextInt();

        ComputerBuilder builder;
        switch (choice) {
            case 1:
                builder = new GamingComputerBuilder();
                break;
            case 2:
                builder = new OfficeComputerBuilder();
                break;
            case 3:
                builder = new BudgetComputerBuilder();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Budget Computer.");
                builder = new BudgetComputerBuilder();
        }

        Director director = new Director(builder);
        director.constructComputer();
        Computer computer = builder.getComputer();

        System.out.println("Computer built:");
        System.out.println(computer);
    }
}
