import threaded.*;
import processing.core.PApplet;
import utils.Utility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * We use different thread for reach algorithm
 */

public class MainThreaded extends PApplet {

    public ArrayList<CanvasThreaded> canvases = new ArrayList<>();
    public Integer[] arr = Utility.generateRandomArray(300);


    public static void main(String[] args) {
        PApplet.main("MainThreaded");
    }

    public void settings() {
        this.size(1600, 1200);

    }

    public void setup() {
        AbstractSortingThreaded thread1 = new RadixSortThreaded("Radix Sort", Arrays.copyOf(arr, arr.length));
        new Thread(thread1).start();
        canvases.add(new CanvasThreaded(this, 0, 0, (float) width / 3 , (float) height / 2, thread1));

        AbstractSortingThreaded thread2 = new BubbleSortThreaded("Bubble sort", Arrays.copyOf(arr, arr.length));
        new Thread(thread2).start();
        canvases.add(new CanvasThreaded(this, (float) width / 3, 0, (float) width / 3, (float) height / 2, thread2));

        AbstractSortingThreaded thread3 = new BogoSortThreaded("Bogo sort", Arrays.copyOf(arr, arr.length));
        new Thread(thread3).start();
        canvases.add(new CanvasThreaded(this, (float) 2 * width / 3, 0, (float) width / 3, (float) height / 2, thread3));

        AbstractSortingThreaded thread4 = new MergeSortThreaded("Merge Sort", Arrays.copyOf(arr, arr.length));
        new Thread(thread4).start();
        canvases.add(new CanvasThreaded(this, 0, (float) height / 2, (float) width / 3, (float) height / 2, thread4));

        AbstractSortingThreaded thread5 = new InsertionSortThreaded("Insertion Sort", Arrays.copyOf(arr, arr.length));
        new Thread(thread5).start();
        canvases.add(new CanvasThreaded(this, (float) width / 3, (float) height / 2, (float) width / 3, (float) height / 2, thread5));

        AbstractSortingThreaded thread6 = new HeapSortThreaded("Heap Sort", Arrays.copyOf(arr, arr.length));
        new Thread(thread6).start();
        canvases.add(new CanvasThreaded(this, (float) 2*width / 3, (float) height / 2, (float) width / 3, (float) height / 2, thread6));


    }

    public void draw() {
        for (CanvasThreaded canvas : canvases) canvas.display();
    }
}
