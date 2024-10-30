import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class History extends Stage {

    private ListView<String> historyList;
    private Controller controller;

    public History(Controller controller) {
        this.controller = controller;
        setTitle("History");
        setWidth(200);
        setHeight(400);

        historyList = new ListView<>();
        Button restoreButton = new Button("Restore");

        restoreButton.setOnAction(event -> {
            int selectedIndex = historyList.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                controller.restoreStateFromHistory(selectedIndex);
            }
        });

        VBox layout = new VBox(10, historyList, restoreButton);
        Scene scene = new Scene(layout);
        setScene(scene);
    }

    public void updateHistory(List<IMemento> history) {
        historyList.getItems().clear();
        for(IMemento memento: history){
            historyList.getItems().add(memento.getStateMetadata());
        }
    }
}
