package core.threaded;

import java.util.Arrays;

public abstract class AbstractSortingThreaded implements Runnable {
    private Integer[] values;
    private Integer[] states;

    private int swapCount;
    private int comparisonCount;

    public AbstractSortingThreaded(Integer[] values) {
        this.values = values;
        this.states = new Integer[values.length];
        Arrays.fill(states, -1);

        this.swapCount = 0;
        this.comparisonCount = 0;
    }

    public void run() {}


    public void incrementComparator( ){
        this.comparisonCount++;
    }
    public void incrementSwap() {
        this.swapCount++;
    }

    public void activateState(int index) {
        this.states[index] = 0;
    }

    public void deactivateState(int index) {
        this.states[index] = 1;
    }

    // getters
    public Integer[] getValues() {
        return this.values;
    }

    public Integer[] getStates() {
        return this.states;
    }

    public int getComparisonCount() {
        return this.comparisonCount;
    }

    public int getSwapCount() {
        return this.swapCount;
    }
}
