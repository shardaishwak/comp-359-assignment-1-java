package threaded;

public class BubbleSortThreaded extends AbstractSortingThreaded {

    public BubbleSortThreaded(String name, Integer[] values) {
        super(name, values);
    }

    @Override
    public void run() {
        this.start();
        try {
            bubbleSort();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.end();
    }

    private void bubbleSort() throws InterruptedException {
        Integer[] arr = getValues();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                activateState(j);
                activateState(j + 1);

                incrementComparator();

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    incrementSwap();

                    Thread.sleep(this.getSpeed());
                }

                deactivateState(j);
                deactivateState(j + 1);

                Thread.sleep(this.getSpeed());
            }
            activateState(n - i - 1);
        }
        for (int i = 0; i < n; i++) {
            deactivateState(i);
        }
    }
}
