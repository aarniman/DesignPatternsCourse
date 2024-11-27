import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Recommendation recommendation = new Recommendation("Adults");

    public static void main(String[] args) {
        // Prepopulate with some books
        recommendation.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 1925));
        recommendation.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Novel", 1960));
        recommendation.addBook(new Book("1984", "George Orwell", "Novel", 1949));

        while (true) {
            System.out.println("\nBook Recommendation System");
            System.out.println("1. View Recommendations");
            System.out.println("2. Clone Recommendation");
            System.out.println("3. Modify Recommendation");
            System.out.println("4. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewRecommendations();
                    break;
                case 2:
                    cloneRecommendation();
                    break;
                case 3:
                    modifyRecommendation();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewRecommendations() {
        System.out.println("\nCurrent Recommendation List:");
        for (Book book : recommendation.getBooks()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    private static void cloneRecommendation() {
        Recommendation clonedRecommendation = recommendation.clone();
        System.out.print("Enter new target audience for cloned recommendation: ");
        String targetAudience = scanner.nextLine();
        clonedRecommendation.setTarget(targetAudience);
        recommendation = clonedRecommendation;
        System.out.println("Recommendation cloned and target audience set to " + targetAudience);
    }

    private static void modifyRecommendation() {
        System.out.println("\nModify Recommendation");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Back");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter book publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book book = new Book(title, author, genre, year);
        recommendation.addBook(book);
        System.out.println("Book added to recommendation list.");
    }

    private static void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();
        Book bookToRemove = null;
        for (Book book : recommendation.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            recommendation.removeBook(bookToRemove);
            System.out.println("Book removed from recommendation list.");
        } else {
            System.out.println("Book not found in recommendation list.");
        }
    }
}