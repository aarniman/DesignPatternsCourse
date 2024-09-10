public class Display implements Observer {
    private final String name;
    private int temperature;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        String message = temperature > 25 ? "It's hot" : temperature < 15 ? "It's cold" : "It's nice";
        System.out.println(name + " - Temperature: " + temperature + "°C - Forecast: " + message);
    }
}
