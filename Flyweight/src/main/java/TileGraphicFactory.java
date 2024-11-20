import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static TileGraphicFactory instance;
    private Map<String, TileGraphic> tileGraphics;

    private TileGraphicFactory() {
        tileGraphics = new HashMap<>();
    }

    public static TileGraphicFactory getInstance() {
        if (instance == null) {
            instance = new TileGraphicFactory();
        }
        return instance;
    }

    public TileGraphic getTileGraphic(String type) {
        if (!tileGraphics.containsKey(type)) {
            tileGraphics.put(type, new TileGraphic(type));
        }
        return tileGraphics.get(type);
    }
}

class TileGraphic {
    private Image image;

    public TileGraphic(String type) {
        this.image = new Image(getClass().getResourceAsStream("/images/" + type + ".png"));
    }

    public void draw(GraphicsContext gc, int x, int y) {
        gc.drawImage(image, x, y);
    }
}
