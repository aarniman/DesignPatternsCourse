import java.io.BufferedWriter;
import java.io.FileWriter;

public class FilePrinter extends PrinterDecorator {

    private static final String FILE_NAME = "output.txt";

    public FilePrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(text);
            writer.newLine();
        } catch (java.io.IOException e) {
            System.err.println("There was an error when writing text to the file: " + e);
        }
        super.print(text);
    }
}
