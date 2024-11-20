import javafx.scene.canvas.GraphicsContext;

public interface Tile {

    char getContent();

    String getType();

    void action();

    void render(GraphicsContext gc, int x, int y);
}
