import java.util.Date;

public interface DocumentInterface {
    int getId();
    String getContent(User user) throws AccessDeniedException;
    Date getDate();
}
