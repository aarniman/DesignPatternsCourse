import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.simple.JSONObject; // add Maven dependency for JSON.simple
import org.json.simple.parser.JSONParser; // add Maven dependency for JSON.simple

public class Main {
    public static void main(String[] args) {
        ApiFacade apiFacade = new ApiFacade();
        try {
            String joke = apiFacade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println(joke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
