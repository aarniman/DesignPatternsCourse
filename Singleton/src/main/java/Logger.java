import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;
    private String filename;

    private Logger() {
        this.filename = "deafult.txt";
        initialize();
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void initialize() {
        try {
            if(writer != null) {
                writer.close();
            }
            writer = new PrintWriter(new FileWriter(filename, true));
        } catch (IOException e) {
            System.err.println("Error initializing file: " + e.getMessage());
        }
    }

    public void write(String message) {
        try {
            writer.println(message);
            writer.flush();
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void setFileName(String filename) {
        this.filename = filename;
        initialize();
    }

    public void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}
