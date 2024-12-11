import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class PixelArtEditorController {
    private static final int SIZE = 8;
    private static final int RECT_SIZE = 40;
    private int cursorX = 0;
    private int cursorY = 0;
    private boolean[][] grid = new boolean[SIZE][SIZE];

    @FXML
    private GridPane gridPane;

    @FXML
    private Button createButton;

    @FXML
    public void initialize() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Rectangle rectangle = new Rectangle(RECT_SIZE, RECT_SIZE);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                gridPane.add(rectangle, i, j);
            }
        }
        updateCursor();
        gridPane.setOnKeyPressed(this::handleKeyPress);
        gridPane.setFocusTraversable(true);
    }

    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()){
            case UP -> moveCursor(-1, 0);
            case DOWN -> moveCursor(1, 0);
            case LEFT -> moveCursor(0, -1);
            case RIGHT -> moveCursor(0, 1);
            case SPACE -> togglePixel();
        }
    }

    private void moveCursor(int dx, int dy) {
        cursorX = Math.max(0, Math.min(SIZE - 1, cursorX + dx));
        cursorY = Math.max(0, Math.min(SIZE - 1, cursorY + dy));
        updateCursor();
    }

    private void togglePixel() {
        grid[cursorY][cursorX] = !grid[cursorY][cursorX];
        updateCursor();
    }

    private void updateCursor() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Rectangle rectangle = (Rectangle) gridPane.getChildren().get(i * SIZE + j);
                if (i == cursorX && j == cursorY) {
                    rectangle.setStroke(Color.RED);
                } else {
                    rectangle.setStroke(Color.BLACK);
                }
            }
        }
    }

    @FXML
    private void handleCreateCode(){
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            code.append("    {");
            for (int j = 0; j < SIZE; j++) {
                code.append(grid[j][i] ? "1" : "0");
                if (j < SIZE - 1) {
                    code.append(", ");
                }
            }
            code.append("}");
            if (i < SIZE - 1) {
                code.append(",\n");
            }
        }
        code.append("\n};");
        System.out.println(code);
    }

}
