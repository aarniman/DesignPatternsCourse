public class main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Display display1 = new Display("Display 1");
        Display display2 = new Display("Display 2");

        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);

        Thread thread = new Thread(weatherStation);
        thread.start();

        try {
            Thread.sleep(10000);
            weatherStation.removeObserver(display1);
            Thread.sleep(10000);
            weatherStation.removeObserver(display2);
            Thread.sleep(10000);
            weatherStation.addObserver(display1);
            Thread.sleep(10000);
            weatherStation.addObserver(display2);
            Thread.sleep(10000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nRemoving Display 2 observer...\n");
        weatherStation.removeObserver(display2);

        try {
            Thread.sleep(10000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
