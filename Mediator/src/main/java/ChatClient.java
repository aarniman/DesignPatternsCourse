import javafx.scene.control.TextArea;

public class ChatClient {
    private String username;
    private ChatMediator mediator;
    private TextArea messageArea;

    public ChatClient(String username, ChatMediator mediator, TextArea messageArea) {
        this.username = username;
        this.mediator = mediator;
        this.messageArea = messageArea;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message, String receiver) {
        mediator.sendMessage(message, username, receiver);
    }

    public void receiveMessage(String message, String sender) {
        messageArea.appendText(sender + ": " + message + "\n");
    }
}
