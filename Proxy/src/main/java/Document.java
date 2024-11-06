import java.nio.file.AccessDeniedException;
import java.util.Date;

public class Document implements DocumentInterface {

    private Date created;
    private int id;
    private String content;

    public Document(int id, String content) {
        this.id = id;
        this.content = content;
        this.created = new Date();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getContent(User user) {
        return content;
    }

    @Override
    public Date getDate() {
        return created;
    }
}
