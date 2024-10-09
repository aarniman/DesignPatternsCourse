public class Main {
    public static void main(String[] args) {
        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler suggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalFeedbackHandler);

        Message msg1 = new Message(MessageType.COMPENSATION_CLAIM, "Requesting compensation for a damaged item", "customer1@example.com");
        Message msg2 = new Message(MessageType.CONTACT_REQUEST, "Please call me back regarding my recent order", "customer2@example.com");
        Message msg3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add more payment options", "customer3@example.com");
        Message msg4 = new Message(MessageType.GENERAL_FEEDBACK, "Great customer service!", "customer4@example.com");

        System.out.println("Processing feedback messages:");
        compensationHandler.handle(msg1);
        compensationHandler.handle(msg2);
        compensationHandler.handle(msg3);
        compensationHandler.handle(msg4);
    }
}
