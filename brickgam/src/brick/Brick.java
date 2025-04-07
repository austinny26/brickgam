package brick;

import java.awt.*;

public class Brick {
    private int start;
    private int end;
    private int height;

    public Brick(int start, int end) {
        this.start = start;
        this.end = end;
        this.height = 0;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String toString() {
        return start + "," + end + " --> Height: " + height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void render(Graphics g){

        for(int k = start; k <= end; k++) {
            g.setColor(Color.red);
            g.fillRect((int) (2.5 * k * 10), (int) (2.5 * counter * 10), 20, 20);
        }

    }

    public void updatePos(){

    }
}