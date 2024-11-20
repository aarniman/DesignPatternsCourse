import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MapRenderer {
    private Tile[][] map;

    public MapRenderer(Tile[][] map) {
        this.map = map;
    }

    public void render(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j].render(gc, j * 16, i * 16);
            }
        }
    }
}
