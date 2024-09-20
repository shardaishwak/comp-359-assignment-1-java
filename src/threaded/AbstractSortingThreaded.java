package threaded;

import java.util.Arrays;

public abstract class AbstractSortingThreaded implements Runnable {
    private String name;
    private Integer[] values;
    private Integer[] states;

    private double startTime;
    private double endTime;

    private int speed;

    private int swapCount;
    private int comparisonCount;

    public AbstractSortingThreaded(String name, Integer[] values) {
        this.values = values;
        this.states = new Integer[values.length];
        Arrays.fill(states, -1);

        this.swapCount = 0;
        this.comparisonCount = 0;
        this.name = name;
        this.speed = 1;
        this.endTime = 0;
        this.startTime = 0;

    }

    public void run() {}

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    public void end() {
        this.endTime = System.currentTimeMillis();
    }
    public void setEndTime(double value) {
        this.endTime = value;
    }

    public double getTimeElapsed() {
        if (endTime != 0) {
            return endTime - startTime;
        } else if (startTime != 0) {
            double sys = System.currentTimeMillis();
            return sys - startTime;
        } else {
            return 0;
        }
    }


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
