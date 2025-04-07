package brick;

import inputs.MouseInputs;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrickLayout implements Statemethods {

    private ArrayList<Brick> bricks;
    private Brick brick;

    private int[][] brickLayout;
    private boolean dropNow;
    private int cols;

    public BrickLayout(String fileName, int cols, boolean dropAllBricks) {
        this.cols = cols;
        ArrayList<String> fileData = getFileData(fileName);
        bricks = new ArrayList<Brick>();
        for (String line : fileData) {
            String[] points = line.split(",");
            int start = Integer.parseInt(points[0]);
            int end = Integer.parseInt(points[1]);
            Brick b = new Brick(start, end);
            bricks.add(b);
        }
        brickLayout = new int[bricks.size()][cols];
        if (dropAllBricks) {
            while (bricks.size() != 0) {
                doOneBrick();
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        drawGrid(g);
        brick.render();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            dropNow = true;
            System.out.println("hi");
        }
    }


    public void dropBrick(Graphics g){
        drawGrid(g);

        int brickMin, brickMax;
        if (bricks.size() != 0) {
            Brick b = bricks.remove(0);
            brickMin = b.getStart();
            brickMax = b.getEnd();
            int counter = 0;

            while (!checkBrickSpot(counter + 1, brickMin) && !checkBrickSpot(counter + 1, brickMax)){
                counter++;
                for(int k = brickMin; k <= brickMax; k++) {
                    g.setColor(Color.red);
                    g.fillRect((int) (2.5 * k * 10), (int) (2.5 * counter * 10), 20, 20);
                }
                for(int k = brickMin; k <= brickMax; k++) {
                    g.setColor(Color.black);
                    g.drawRect((int) (2.5 * (k) * 10), (int) (2.5 * (counter - 1) * 10), 20, 20);
                }
            }
            for(int k = brickMin; k <= brickMax; k++){
                brickLayout[counter][k] = 1;
            }



            /*while (!checkBrickSpot(counter + 1, brickMin) && !checkBrickSpot(counter + 1, brickMax)) {
                counter++;
                for(int k = brickMin; k <= brickMax; k++){
                        g.fillRect((int)(k*2.5*10),(int)(counter*2.5*10),20,20);
                }
            }
            for (int i = brickMin; i <= brickMax; i++) {
                try {
                    brickLayout[counter][i] = 1;
                } catch (ArrayIndexOutOfBoundsException _) {}
            }

             */
        }
    }

    public void drawGrid(Graphics g) {
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 30; j++) {
                if(brickLayout[j][i] == 0) {
                    g.setColor(Color.black);
                    g.drawRect((int) (2.5 * 10 * i), (int) (2.5 * 10 * j), 20, 20);
                }
                else{
                    g.setColor(Color.red);
                    g.fillRect((int) (2.5 * 10 * i), (int) (2.5 * 10 * j), 20, 20);
                }
            }
        }
    }


    public void printBrickLayout() {
        for (int r = 0; r < brickLayout.length; r++) {
            for (int c = 0; c < brickLayout[0].length; c++) {
                System.out.print(brickLayout[r][c] + " ");
            }
            System.out.println();
        }
    }


    public int[][] getBrickLayout() {
        return brickLayout;
    }


    @Override
    public void update() {

    }

    public boolean checkBrickSpot(int r, int c) {
        try {
            if (!(brickLayout[r][c] == 0)) {
                return true;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    public ArrayList<String> getFileData(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        return fileData;
    }

    public void doOneBrick() {
        int brickMin, brickMax;
        if (bricks.size() != 0) {
            Brick b = bricks.remove(0);


            brickMin = b.getStart();
            brickMax = b.getEnd();
            int counter = 0;


            while (!checkBrickSpot(counter + 1, brickMin) && !checkBrickSpot(counter + 1, brickMax)) {
                counter++;
            }
            for (int i = brickMin; i <= brickMax; i++) {
                try {
                    brickLayout[counter][i] = 1;
                } catch (ArrayIndexOutOfBoundsException _) {}
            }
        }

    }

}