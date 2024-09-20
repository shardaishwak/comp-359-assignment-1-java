package threaded;

public class MergeSortThreaded extends AbstractSortingThreaded{

    public MergeSortThreaded(String name,Integer[] values) {
        super(name, values);
    }

    @Override
    public void run() {
        this.start();
        mergeSort(getValues(), 0, getValues().length - 1);
        this.end();
    }

    private void mergeSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    private void merge(Integer[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Integer[] L = new Integer[n1];
        Integer[] R = new Integer[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];


        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            try {
                Thread.sleep(this.getSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            incrementComparator();
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            activateState(k);
            k++;
        }

        while (i < n1) {
            try {
                Thread.sleep(this.getSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            arr[k] = L[i];
            i++;
            activateState(k);
            k++;
        }

        while (j < n2) {
            try {
                Thread.sleep(this.getSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            arr[k] = R[j];
            j++;
            activateState(k);
            k++;
        }

        for (int idx = left; idx <= right; idx++) {
            try {
                Thread.sleep(this.getSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            deactivateState(idx);
        }
    }
}
