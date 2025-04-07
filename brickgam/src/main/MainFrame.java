package main;
import brick.BrickLayout;
import java.awt.*;

public class MainFrame implements Runnable {

    private GameWindow gameWindow;
    private DrawPanel drawPanel;
    private Thread windowThread;

    private BrickLayout brickLayout;


    private final int FPS_SET = 10;
    private final int UPS_SET = 20;

    public MainFrame() {
        initClasses();

        drawPanel = new DrawPanel(this);
        gameWindow = new GameWindow(drawPanel);


        startThread();
    }

    public void initClasses(){
        brickLayout = new BrickLayout("src/bricks", 40, false);
    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void update(){}


    public void render(Graphics g){
        brickLayout.draw(g);
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

    public BrickLayout getBrickLayout(){
        return brickLayout;
    }

}
