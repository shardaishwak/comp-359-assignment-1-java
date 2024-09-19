import core.threaded.*;
import processing.core.PApplet;
import utils.Utility;

import java.util.Arrays;

public class MainThreaded extends PApplet {

    CanvasThreaded canvas1, canvas2, canvas3, canvas4;
    public Integer[] arr = Utility.generateRandomArray(100);


    public static void main(String[] args) {
        PApplet.main("MainThreaded");
    }

    public void settings() {
        this.size(1200, 1200);

    }

    public void setup() {
        RadixSortThreaded r = new RadixSortThreaded(Arrays.copyOf(arr, arr.length));
        new Thread(r).start();
        canvas1 = new CanvasThreaded(this, 0, 0, (float) width /2 , (float) height /2, r);

        BubbleSortThreaded b = new BubbleSortThreaded(Arrays.copyOf(arr, arr.length));
        new Thread(b).start();
        canvas2 = new CanvasThreaded(this, (float) width / 2, 0, (float) width / 2, (float) height / 2, b);

        CountingSortThreaded c = new CountingSortThreaded(Arrays.copyOf(arr, arr.length));
        new Thread(c).start();
        canvas3 = new CanvasThreaded(this, 0, (float) height / 2, (float) width / 2, (float) height / 2, c);

        MergeSortThreaded m = new MergeSortThreaded(Arrays.copyOf(arr, arr.length));
        new Thread(m).start();
        canvas4 = new CanvasThreaded(this, (float) width / 2, (float) height / 2, (float) width / 2, (float) height / 2, m);

    }

    public void draw() {
        canvas1.display();
        canvas2.display();
        canvas3.display();
        canvas4.display();
    }
}
