package core;

public class BubbleSort extends AbstractSorting {
    private int i;
    private int j;
    private boolean swapped; // this will help understand if we finished or not. if no swap: finished since it is sorted

    public BubbleSort(Integer[] array) {
        super(array);
        this.i = 0;
        this.j = 0;
        this.swapped = false;
    }

    @Override
    public void nextStep() {
        Integer[] values = getValues();

        if (i >= values.length - 1) {
            System.out.println("Sorting is complete!");
            return;
        }

        incrementComparator();
        if (values[j] > values[j + 1]) {
            int temp = values[j];
            values[j] = values[j + 1];
            values[j + 1] = temp;
            incrementSwap();
            swapped = true;
        }

        j++;

        if (j >= values.length - i - 1) {
            if (!swapped) {
                i = values.length;
                System.out.println("Sorting is complete!");
                return;
            }
            j = 0;
            i++;
            swapped = false;
        }
    }
}
