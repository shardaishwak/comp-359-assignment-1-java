package core.threaded;

import java.util.Arrays;

public class RadixSortThreaded extends AbstractSortingThreaded {

    public RadixSortThreaded(Integer[] values) {
        super(values);
    }

    @Override
    public void run() {
        try {
            radixSort();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getMax(Integer[] arr) {
        return Arrays.stream(arr).max(Integer::compare).orElse(0);
    }

    private void countingSortByDigit(Integer[] arr, int exp) throws InterruptedException {
        int n = arr.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            int index = (arr[i] / exp) % 10;
            count[index]++;
            activateState(i);
            Thread.sleep(50);
            deactivateState(i);
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            activateState(i);
            Thread.sleep(50);
            deactivateState(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
            activateState(i);
            Thread.sleep(50);
            deactivateState(i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
            activateState(i);
            Thread.sleep(50);
            deactivateState(i);
        }
    }

    private void radixSort() throws InterruptedException {
        Integer[] arr = getValues();
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
}
