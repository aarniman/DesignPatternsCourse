import javafx.scene.canvas.GraphicsContext;

public class RoadTile implements Tile{
    private static final String TYPE = "Road";
    private static final char CONTENT = '=';

    @Override
    public char getContent() {
        return CONTENT;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void action() {

    }

    @Override
    public void render(GraphicsContext gc, int x, int y) {
        TileGraphicFactory.getInstance().getTileGraphic(TYPE).draw(gc, x, y);
    }
}
