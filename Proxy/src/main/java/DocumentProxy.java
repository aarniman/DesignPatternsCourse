import java.util.Date;

public class DocumentProxy implements DocumentInterface{

    private Document document;
    private AccessControlService acs;

    public DocumentProxy(Document document) {
        this.document = document;
        this.acs = AccessControlService.getInstance();
    }

    @Override
    public int getId() {
        return document.getId();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (acs.isAllowed(document.getId(), user.getUsername())) {
            return document.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }

    @Override
    public Date getDate() {
        return document.getDate();
    }
}
