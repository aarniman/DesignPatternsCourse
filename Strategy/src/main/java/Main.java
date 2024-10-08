import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(100000);

        SortingContext context = new SortingContext(new QuickSort());

        //Measure time for QuickSort
        measureSortTime(context, smallArray.clone(), "QuickSort", "small");
        measureSortTime(context, largeArray.clone(), "QuickSort", "large");

        //Measure time for RadixSort
        context.setSortingStrategy(new RadixSort());
        measureSortTime(context, smallArray.clone(), "RadixSort", "small");
        measureSortTime(context, largeArray.clone(), "RadixSort", "large");

        //Measure time for BitonicSort
        context.setSortingStrategy(new BitonicSort());
        measureSortTime(context, smallArray.clone(), "BitonicSort", "small");
        measureSortTime(context, largeArray.clone(), "BitonicSort", "large");

    }

    private static void measureSortTime(SortingContext context, int[] array, String sortType, String arraySize) {
        long startTime = System.nanoTime();
        context.sort(array, array.length, 0);
        long endTime = System.nanoTime();
        System.out.println(sortType + " time for " + arraySize + " array: " + (endTime - startTime) + " nanoseconds");
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000); // Generate random integers between 0 and 999
        }
        return array;
    }
}
