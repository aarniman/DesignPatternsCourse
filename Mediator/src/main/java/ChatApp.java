import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatApp extends Application {
    private ChatMediator mediator = new ConcreteChatMediator();

    @Override
    public void start(Stage stage) throws Exception {
        createClientWindow("Alice");
        createClientWindow("Bob");
        createClientWindow("John");
    }

    private void createClientWindow(String username) {
        Stage stage = new Stage();
        stage.setTitle(username);

        TextArea messageArea = new TextArea();
        messageArea.setEditable(false);

        TextField messageField = new TextField();
        TextField receiverField = new TextField();
        Button sendButton = new Button("Send");

        ChatClient client = new ChatClient(username, mediator, messageArea);

        sendButton.setOnAction(e -> {
            client.sendMessage(messageField.getText(), receiverField.getText());
            messageField.clear();
        });

        VBox layout = new VBox(10, new Label("Messages:"), messageArea, new Label("Recipient:"), receiverField, new Label("Message:"), messageField, sendButton);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 300, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
