package core;

import java.util.Arrays;

public class MergeSort extends AbstractSorting {
    private int currentSize;
    private int leftStart;
    private boolean done;

    public MergeSort(Integer[] array) {
        super(array);
        this.currentSize = 1;
        this.leftStart = 0;
        this.done = false;
    }

    // This will run step by step.
    // This means, we can also have a button to manually move it forward
    // TODO: Can we move it backwards?
    public void nextStep() {
        if (done) {
            System.out.println("Sorting is complete!");
            return;
        }

        if (currentSize >= getValues().length) {
            done = true;
            System.out.println("Sorting is complete!");
            return;
        }

        if (leftStart < getValues().length - 1) {
            int mid = Math.min(leftStart + currentSize - 1, getValues().length - 1);
            int rightEnd = Math.min(leftStart + 2 * currentSize - 1, getValues().length - 1);
            merge(leftStart, mid, rightEnd);
            leftStart += 2 * currentSize;
        } else {
            leftStart = 0;
            currentSize *= 2;
        }

        System.out.println("Array after next step: " + Arrays.toString(getValues()));
    }

    private void merge(int left, int mid, int right) {
        Integer[] arr = getValues();

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Integer[] leftArray = new Integer[n1];
        Integer[] rightArray = new Integer[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            incrementComparator();
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
//                activateState(k);
                i++;
            } else {
                arr[k] = rightArray[j];
//                activateState(k);
                j++;
            }
//            deactivateState(k);
            k++;

        }
        while (i < n1) {
            arr[k] = leftArray[i];
//            activateState(k);
            i++;
//            deactivateState(k);
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
//            activateState(k);
            j++;
//            deactivateState(k);
            k++;
        }
    }
}
