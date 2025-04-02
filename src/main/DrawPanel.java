package main;

import brick.BrickLayout;
import inputs.MouseInputs;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener{

    private MainFrame mainFrame;
    private MouseInputs mouseInputs;
    BrickLayout b = new BrickLayout("src/bricks", 40, true);



    public DrawPanel(MainFrame mainFrame) {
        mouseInputs = new MouseInputs(this);
        this.mainFrame = mainFrame;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        mainFrame.render(g);
    }

    public MainFrame getMainFrame(){return mainFrame;}

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /* public void setThirty(){
        int rand = (int)(Math.random() * 10);

        for(int i = 0; i < 40; i++) {
            for (int j = 0; j < 30; j++) {
                if(rand < 3){
                    array[i][j] = true;
                }
                rand = (int)(Math.random() * 10);
            }
        }
    }
    */


}
