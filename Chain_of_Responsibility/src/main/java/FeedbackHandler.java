abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(Message message);
}

class CompensationClaimHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Handling compensation claim: " + message.getContent());
            // logic to approve/reject compensation claims
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}

class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Handling contact request: " + message.getContent());
            // logic to forward contact request
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}

class DevelopmentSuggestionHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Logging development suggestion: " + message.getContent());
            // logic to log and prioritize suggestions
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}

class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("Handling general feedback: " + message.getContent());
            // logic to analyze and respond to general feedback
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}