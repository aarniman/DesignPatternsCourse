import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, DocumentInterface> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addDocument(DocumentInterface document) {
        documents.put(document.getId(), document);
    }

    public DocumentInterface getDocument(int id){
        return documents.get(id);
    }

    public void addProtectedDocument(int id, String content) {
        Document document = new Document(id, content);
        DocumentProxy documentProxy = new DocumentProxy(document);
        addDocument(documentProxy);

    }
}
