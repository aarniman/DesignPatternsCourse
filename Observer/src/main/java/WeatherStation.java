import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Observable, Runnable{

    private List<Observer> observers;
    private int temperature;
    private final Random random;
    private final int minTemperature = -10;
    private final int maxTemperature = 40;

    public WeatherStation() {
        this.observers = new ArrayList<>();
        this.random = new Random();
        this.temperature = random.nextInt(maxTemperature - minTemperature + 1) + minTemperature;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
    
    public void updateTemperature() {
        int change = random.nextInt(3)-1;
        temperature += change;
        if (temperature < minTemperature) {
            temperature = minTemperature;
        } else if (temperature > maxTemperature) {
            temperature = maxTemperature;
        }
    }
    
    @Override
    public void run() {
        while (true) {
            updateTemperature();
            notifyObservers();
            try {
                Thread.sleep(random.nextInt(5000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
