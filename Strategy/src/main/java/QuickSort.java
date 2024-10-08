/*SORTING CODE WAS PROVIDED BY GEEKSFORGEEKS AND NOT WRITTEN BY ME
  I DO NOT TAKE CREDIT FOR THIS CODE
  I AM USING THIS CODE FOR EDUCATIONAL PURPOSES */

import java.util.Arrays;

class QuickSort implements SortingStrategy {

    // Partition function
    static int partition(int[] arr, int low, int high) {

        // Choose the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates 
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low.high] and move all smaller
        // elements to the left side. Elements from low to 
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // The QuickSort function implementation
    @Override
    public void sort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    //Calling Quick Sort QuickSort ob = new QuickSort(); ob.quickSort(arr, 0, n-1); n=arr.length;
}