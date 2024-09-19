import core.*;
import processing.core.PApplet;
import utils.Utility;

import java.util.Arrays;

public class Main extends PApplet {

    Canvas canvas1, canvas2, canvas3, canvas4;
    MergeSort mergeSort;
    public Integer[] arr = Utility.generateRandomArray(50);


    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        this.size(1200, 1200);

    }

    public void setup() {
//        this.frameRate(20);

        canvas1 = new Canvas(this, 0, 0, (float) width /2 , (float) height /2, new MergeSort(Arrays.copyOf(arr, arr.length)));
        canvas2 = new Canvas(this, (float) width / 2, 0, (float) width / 2, (float) height / 2, new QuickSort(Arrays.copyOf(arr, arr.length)));
        canvas3 = new Canvas(this, 0, (float) height / 2, (float) width / 2, (float) height / 2, new BubbleSort(Arrays.copyOf(arr, arr.length)));
        canvas4 = new Canvas(this, (float) width / 2, (float) height / 2, (float) width / 2, (float) height / 2, new RadixSort(Arrays.copyOf(arr, arr.length)));
    }

    public void draw() {
        canvas1.display();
        canvas2.display();
        canvas3.display();
        canvas4.display();
    }
}
