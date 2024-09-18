package core;

import processing.core.PApplet;
import processing.core.PGraphics;

public class Canvas  {
    PGraphics pg;
    float x, y, width, height;
    PApplet p;

    Integer[] data;

    public Canvas(PApplet p, float x, float y, float width, float height, Integer[] data) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.pg = p.createGraphics((int) width, (int) height);
        this.data = data;
    }

    public void draw() {
        float rectWidth = this.width / this.data.length;

        for (int i = 0; i < this.data.length; i++) {
            this.pg.rect(i * rectWidth, this.height - data[i], rectWidth, data[i]);
        }
    }
}
