package main;

import brick.BrickLayout;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MainFrame implements Runnable {

    private GameWindow gameWindow;
    private DrawPanel drawPanel;
    private Thread windowThread;
    BrickLayout b = new BrickLayout("src/bricks", 40, true);


    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    public MainFrame() {

        drawPanel = new DrawPanel(this);
        gameWindow = new GameWindow(drawPanel);

        startThread();
    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void update(){}


    public void render(Graphics g){
        b.drawGrid(g);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){

        }
    }


    public void run() {
        while (true) {
            drawPanel.repaint();
            double timePerFrame = 1000000000.0 / FPS_SET;
            double timePerUpdate = 1000000000.0 / UPS_SET;

            long previousTime = System.nanoTime();

            int frames = 0;
            int updates = 0;
            long lastCheck = System.currentTimeMillis();

            double deltaU = 0;
            double deltaF = 0;

            while (true) {
                long currentTime = System.nanoTime();

                deltaU += (currentTime - previousTime) / timePerUpdate;
                deltaF += (currentTime - previousTime) / timePerFrame;
                previousTime = currentTime;

                if (deltaU >= 1) {
                    update();
                    updates++;
                    deltaU--;
                }

                if (deltaF >= 1) {
                    drawPanel.repaint();
                    frames++;
                    deltaF--;
                }

                if (System.currentTimeMillis() - lastCheck >= 1000) {
                    lastCheck = System.currentTimeMillis();
                    System.out.println("FPS: " + frames + " | UPS: " + updates);
                    frames = 0;
                    updates = 0;

                }
            }
        }


    }
}
