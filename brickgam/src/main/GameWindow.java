package main;

import javax.swing.*;

public class GameWindow {
    private JFrame jframe;

public GameWindow (DrawPanel drawPanel){
    jframe = new JFrame();
    int frameWidth = 1000;
    int frameHeight = 800;
    jframe.add(drawPanel);
    jframe.pack();
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setSize(frameWidth, frameHeight);
    jframe.setLocation(100, 10);
    jframe.setVisible(true);
}

}
