import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        Character character = new Character(name);

        while (!(character.getState() instanceof MasterState)) {
            character.displayStatus();
            System.out.println("Choose an action: train, meditate, fight");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid action. Try again.");
            }
        }

        System.out.println("Congratulations! You've completed the game!");
        scanner.close();
    }
}
