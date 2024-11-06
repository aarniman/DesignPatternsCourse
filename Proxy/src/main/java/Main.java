public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService accessControlService = AccessControlService.getInstance();

        User user1 = new User("user1");
        User user2 = new User("user2");

        Document document1 = new Document(1, "Unprotected Document Content");
        library.addDocument(document1);

        library.addProtectedDocument(2, "Protected Document Content");
        accessControlService.allowAccess(2, "user1");

        try {
            System.out.println("User1 accessing doc1: " + library.getDocument(1).getContent(user1));
            System.out.println("User1 accessing doc2: " + library.getDocument(2).getContent(user1));
            System.out.println("User2 accessing doc1: " + library.getDocument(1).getContent(user2));
            System.out.println("User2 accessing doc2: " + library.getDocument(2).getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
