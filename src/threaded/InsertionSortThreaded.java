package threaded;

public class InsertionSortThreaded extends AbstractSortingThreaded {

    public InsertionSortThreaded(String name, Integer[] values) {
        super(name, values);
    }

    @Override
    public void run() {
        this.start();
        try {
            insertionSort();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.end();
    }

    private void insertionSort() throws InterruptedException {
        Integer[] arr = getValues();
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            activateState(i);
            Thread.sleep(this.getSpeed());

            while (j >= 0 && arr[j] > key) {
                incrementComparator();

                arr[j + 1] = arr[j];
                incrementSwap();

                activateState(j);
                Thread.sleep(this.getSpeed());

                deactivateState(j + 1);
                Thread.sleep(this.getSpeed());

                j = j - 1;
            }

            arr[j + 1] = key;
            incrementSwap();

            deactivateState(i);
            deactivateState(j + 1);
        }

        for (int i = 0; i < n; i++) {
            activateState(i);
            Thread.sleep(this.getSpeed());
            deactivateState(i);
        }
    }
}
