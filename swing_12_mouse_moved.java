import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class swing_12_mouse_moved extends JFrame {
    
    int x = -10, y = -10;
    final int diameter = 50;

    public swing_12_mouse_moved() {

        DrawingPannel canvas = new DrawingPannel();
        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                canvas.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // not needed
            }
        });

        add(canvas);
        setLocationRelativeTo(null);
        setTitle("Mouse Moved Example");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class DrawingPannel extends JPanel {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillOval(x-diameter/2, y-diameter/2, diameter, diameter);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new swing_12_mouse_moved();
        });
    }
}