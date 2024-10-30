import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory; // Redo history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        redoHistory.clear(); // Clear redo history when a new change is made
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        redoHistory.clear(); // Clear redo history when a new change is made
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            redoHistory.add(model.createMemento()); // Save current state to redo history
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");
            IMemento redoState = redoHistory.remove(redoHistory.size() - 1);
            history.add(model.createMemento()); // Save current state to history
            model.restoreState(redoState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    public List<IMemento> getHistory() {
        return history;
    }

    public void restoreStateFromHistory(int index) {
        if (index >= 0 && index < history.size()) {
            IMemento memento = history.get(index);
            model.restoreState(memento);
            gui.updateGui();
        }
    }
}