package core.threaded;

import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.Arrays;

public class CanvasThreaded  {
    PGraphics pg;
    float x, y, width, height;
    PApplet p;

    AbstractSortingThreaded sorting;

    int maxValue;

    public CanvasThreaded(PApplet p, float x, float y, float width, float height, AbstractSortingThreaded sorting) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.pg = p.createGraphics((int) width, (int) height);
        this.sorting = sorting;
        this.maxValue = this.max(sorting.getValues());
    }

    public void display() {

        pg.beginDraw();
        pg.background(0);  // Clear the screen

        Integer[] values = sorting.getValues();
        Integer[] states = sorting.getStates();  // Retrieve the states to visualize comparisons
        float rectWidth = width / (float) values.length;
        float fact = this.height / (float) this.maxValue;

        for (int i = 0; i < values.length; i++) {
            if (states[i] == 0) {
                pg.fill(255, 0, 0);
            } else if (states[i] == 1) {
                pg.fill(0, 255, 0);
            } else {
                pg.fill(100, 100, 255);
            }

            pg.rect(i * rectWidth, this.height - values[i] * fact, rectWidth, values[i] * fact);
        }

// Step through the sorting process
        pg.endDraw();
        p.image(pg, x, y);
//        sorting.nextStep();

    }

    public int max(Integer[] values) {
        int max = Integer.MIN_VALUE;
        for (Integer value : values) {
            max = Math.max(value, max);
        }

        return max;
    }




}
