import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import threaded.*;
import utils.Utility;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MainThreadedTest {
    static Integer[] values;
    static Integer[] sorted;
    @BeforeAll
    public static void init() {
        values = Utility.generateRandomArray(100);
        sorted = Arrays.copyOf(values, values.length);
        Arrays.sort(sorted);
    }
    @Test
    @DisplayName("Check Bubble Sort sorting algorithm")
    void bubbleSort() {
        AbstractSortingThreaded bubbleSort = new BubbleSortThreaded("Bubble sort", Arrays.copyOf(values, values.length));
        bubbleSort.setSpeed(0);
        bubbleSort.run();
        assertArrayEquals(bubbleSort.getValues(), sorted);
    }

    @Test
    @DisplayName("Check Insertion Sort sorting algorithm")
    void insertionSort() {
        AbstractSortingThreaded insertionSort = new InsertionSortThreaded("Insertion sort", Arrays.copyOf(values, values.length));
        insertionSort.setSpeed(0);
        insertionSort.run();
        assertArrayEquals(insertionSort.getValues(), sorted);
    }

    @Test
    @DisplayName("Check Merge Sort sorting algorithm")
    void mergeSort() {
        AbstractSortingThreaded mergeSort = new MergeSortThreaded("Merge sort", Arrays.copyOf(values, values.length));
        mergeSort.setSpeed(0);
        mergeSort.run();
        assertArrayEquals(mergeSort.getValues(), sorted);
    }


    @Test
    @DisplayName("Check Heap Sort sorting algorithm")
    void heapSort() {
        AbstractSortingThreaded heapSort = new HeapSortThreaded("Heap sort", Arrays.copyOf(values, values.length));
        heapSort.setSpeed(0);
        heapSort.run();
        assertArrayEquals(heapSort.getValues(), sorted);
    }

    @Test
    @DisplayName("Check Radix Sort sorting algorithm")
    void radixSort() {
        AbstractSortingThreaded radixSort = new RadixSortThreaded("Radix sort", Arrays.copyOf(values, values.length));
        radixSort.setSpeed(0);
        radixSort.run();
        assertArrayEquals(radixSort.getValues(), sorted);
    }

}