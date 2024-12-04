import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new FibonacciSequence();
        Iterator<Integer> iterator = sequence.iterator();

        for (int i = 0; i < 20; i++) {
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}
