package core;

import java.util.Arrays;

public class RadixSort extends AbstractSorting {
    private int maxVal;
    private int exp;
    private boolean isSorted;
    private int[] countArray;
    private Integer[] outputArray;

    public RadixSort(Integer[] array) {
        super(array);
        this.maxVal = findMax(array);
        this.exp = 1;
        this.isSorted = false;
        this.outputArray = new Integer[array.length];
        this.countArray = new int[10];
    }

    private int findMax(Integer[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @Override
    public void nextStep() {
        if (isSorted) {
            System.out.println("Sorting is complete!");
            return;
        }

        countingSortByDigit();

        if (maxVal / exp == 0) {
            isSorted = true;
        } else {
            exp *= 10;
        }
    }

    private void countingSortByDigit() {
        Integer[] values = getValues();

        Arrays.fill(countArray, 0);

        for (Integer value : values) {
            incrementComparator();
            int digit = (value / exp) % 10;
            countArray[digit]++;
        }
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }
        for (int i = values.length - 1; i >= 0; i--) {
            int digit = (values[i] / exp) % 10;
            outputArray[countArray[digit] - 1] = values[i];
            countArray[digit]--;
        }
        for (int i = 0; i < values.length; i++) {
            incrementSwap();
            values[i] = outputArray[i];
        }
    }
}
