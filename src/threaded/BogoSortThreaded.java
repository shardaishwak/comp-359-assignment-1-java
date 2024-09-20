package threaded;

import java.util.Random;

public class BogoSortThreaded extends AbstractSortingThreaded {

    private Random random = new Random();

    public BogoSortThreaded(String name, Integer[] values) {
        super(name, values);
    }

    @Override
    public void run() {
        this.start();
        try {
            bogoSort();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.end();
    }

    private boolean isSorted(Integer[] arr) throws InterruptedException {
        for (int i = 0; i < arr.length - 1; i++) {
            incrementComparator();
            activateState(i);
            activateState(i + 1);
            Thread.sleep(this.getSpeed());
            deactivateState(i);
            deactivateState(i + 1);

            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void shuffle(Integer[] arr) throws InterruptedException {
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = random.nextInt(arr.length);

            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;

            incrementSwap();

            activateState(i);
            activateState(randomIndex);

            Thread.sleep(this.getSpeed());

            deactivateState(i);
            deactivateState(randomIndex);
        }
    }

    private void bogoSort() throws InterruptedException {
        Integer[] arr = getValues();

        while (!isSorted(arr)) {
            shuffle(arr);
        }

        for (int i = 0; i < arr.length; i++) {
            activateState(i);
            Thread.sleep(this.getSpeed());
            deactivateState(i);
        }
    }
}
