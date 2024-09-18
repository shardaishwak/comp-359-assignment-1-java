package core;

import processing.core.PApplet;
import processing.core.PGraphics;

public class Canvas  {
    PGraphics pg;
    float x, y, width, height;
    PApplet p;

    AbstractSorting sorting;

    int maxValue;

    public Canvas(PApplet p, float x, float y, float width, float height, AbstractSorting sorting) {
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
            {
                // Inactive state
                pg.fill(100, 100, 255);  // Blue for default elements
            }

            // Draw the rectangle representing the element
            pg.rect(i * rectWidth, this.height - values[i] * fact, rectWidth, values[i] * fact);
        }

// Step through the sorting process
        pg.endDraw();
        p.image(pg, x, y);
        sorting.nextStep();

    }

    public int max(Integer[] values) {
        int max = Integer.MIN_VALUE;
        for (Integer value : values) {
            max = Math.max(value, max);
        }

        return max;
    }




}
