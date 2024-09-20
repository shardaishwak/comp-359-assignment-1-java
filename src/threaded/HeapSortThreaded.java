package threaded;

public class HeapSortThreaded extends AbstractSortingThreaded {

    public HeapSortThreaded(String name, Integer[] values) {
        super(name, values);
    }

    @Override
    public void run() {
        this.start();
        try {
            heapSort();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.end();
    }

    private void heapify(Integer[] arr, int n, int i) throws InterruptedException {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            incrementSwap();

            activateState(i);
            activateState(largest);
            Thread.sleep(this.getSpeed());

            deactivateState(i);
            deactivateState(largest);

            heapify(arr, n, largest);
        }
        incrementComparator();
    }

    private void heapSort() throws InterruptedException {
        Integer[] arr = getValues();
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            incrementSwap();

            activateState(0);
            activateState(i);
            Thread.sleep(this.getSpeed());

            deactivateState(0);
            deactivateState(i);

            heapify(arr, i, 0);
        }

        for (int i = 0; i < n; i++) {
            activateState(i);
            Thread.sleep(this.getSpeed());
            deactivateState(i);
        }
    }
}
