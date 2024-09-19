package core;

import java.util.Arrays;

public abstract class AbstractSorting {
    private Integer[] values;
    private Integer[] states;
    private boolean isSorted;

    private int swapCount;
    private int comparisonCount;

    public AbstractSorting(Integer[] values) {
        this.values = values;
        this.states = new Integer[values.length];
        Arrays.fill(states, -1);

        this.isSorted  = false;
        this.swapCount = 0;
        this.comparisonCount = 0;

    }

    public void nextStep() {}


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
