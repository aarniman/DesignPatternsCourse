import java.util.HashMap;
import java.util.Map;

public class ConcreteChatMediator implements ChatMediator{
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String message, String sender, String receiver) {
        ChatClient client = clients.get(receiver);
        if (client != null) {
            client.receiveMessage(message, sender);
        }
    }
}
