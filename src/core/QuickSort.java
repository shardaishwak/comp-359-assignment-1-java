package core;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort extends AbstractSorting {
    private Stack<int[]> stack;
    private boolean done;
    private int low, high;

    public QuickSort(Integer[] array) {
        super(array);
        this.done = false;
        this.stack = new Stack<>();
        this.low = 0;
        this.high = array.length - 1;
        stack.push(new int[]{low, high});
    }

    public void nextStep() {
        if (done) {
            System.out.println("Sorting is complete!");
            return;
        }

        if (!stack.isEmpty()) {
            int[] range = stack.pop();
            low = range[0];
            high = range[1];

            if (low < high) {
                int pivotIndex = partition(low, high);

                stack.push(new int[]{low, pivotIndex - 1});
                stack.push(new int[]{pivotIndex + 1, high});
            }
        }

        if (stack.isEmpty()) {
            done = true;
            System.out.println("Sorting is complete!");
        }

        System.out.println("Array after next step: " + Arrays.toString(getValues()));
    }

    private int partition(int low, int high) {
        Integer[] arr = getValues();
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            incrementComparator();
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
