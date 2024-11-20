import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("RPG Map");

        Tile[][] map = generateMap();
        MapRenderer renderer = new MapRenderer(map);

        Canvas canvas = new Canvas(800, 600);
        renderer.render(canvas);

        Pane pane = new Pane();
        pane.getChildren().add(canvas);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    private Tile[][] generateMap() {
        return new Tile[20][15];
    }

    public static void main(String[] args) {
        launch(args);
    }
}