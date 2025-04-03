package inputs;

import main.DrawPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputs implements MouseListener {

    private DrawPanel drawPanel;

    public MouseInputs(DrawPanel drawPanel){this.drawPanel = drawPanel;}

    @Override
    public void mouseClicked(MouseEvent e) {
        drawPanel.getMainFrame().getBrickLayout().mouseClicked(e);
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
}
//