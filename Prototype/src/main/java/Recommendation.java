import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
    private String target;
    private List<Book> books;

    public Recommendation(String target){
        this.target = target;
        this.books = new ArrayList<>();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation clone = (Recommendation) super.clone();
            clone.books = new ArrayList<>();
            for (Book book : books) {
                clone.addBook(book.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
