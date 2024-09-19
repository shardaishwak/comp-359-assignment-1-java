package core;

public class CountingSort extends AbstractSorting {
    private int[] countArray;
    private Integer[] outputArray;
    private int maxVal;
    private int step;
    private int index;

    public CountingSort(Integer[] array) {
        super(array);
        this.maxVal = findMax(array);
        this.countArray = new int[maxVal + 1];
        this.outputArray = new Integer[array.length];
        this.step = 0;
        this.index = 0;
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
        Integer[] values = getValues();

        switch (step) {
            case 0 -> {
                if (index < values.length) {
                    incrementComparator();
                    countArray[values[index]]++;
                    index++;
                } else {
                    index = 1;
                    step++;
                }
            }
            case 1 -> {
                if (index <= maxVal) {
                    countArray[index] += countArray[index - 1];
                    index++;
                } else {
                    index = values.length - 1;
                    step++;
                }
            }
            case 2 -> {
                if (index >= 0) {
                    incrementComparator();
                    int value = values[index];
                    outputArray[countArray[value] - 1] = value;
                    countArray[value]--;
                    index--;
                } else {
                    index = 0;
                    step++;
                }
            }
            case 3 -> {
                if (index < values.length) {
                    incrementSwap();
                    values[index] = outputArray[index];
                    index++;
                } else {
                    step = -1;
                }
            }
        }
    }
}
