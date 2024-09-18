import core.Canvas;
import processing.core.PApplet;
import utils.Utility;


public class Main extends PApplet {
    Canvas canvas1, canvas2, canvas3, canvas4;
    public Integer[] arr = Utility.generateArray(100);

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        this.size(400, 400);
    }

    public void draw() {


    }


}