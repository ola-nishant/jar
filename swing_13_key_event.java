import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class swing_13_key_event extends JFrame {

    int squareSize = 50;
    Color squareColor = Color.RED;
    final int size_inc = 10;

    public swing_13_key_event() {
        
        DrawingPannel canvas = new DrawingPannel();
        Random rand = new Random();
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                switch (key) {
                    case KeyEvent.VK_UP:
                        squareSize += size_inc;
                        break;
                    case KeyEvent.VK_DOWN:
                        squareSize -= size_inc;
                        break;
                    case KeyEvent.VK_SPACE:
                        squareColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                        break;
                }

                canvas.repaint();
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // not needed
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // not needed
            }
        });


        add(canvas);
        setTitle("Key Event Example");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DrawingPannel extends JPanel {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(squareColor);
            int x = (getWidth() - squareSize) / 2;
            int y = (getHeight() - squareSize) / 2;
            g.fillRect(x, y, squareSize, squareSize);
        }
    }

    public static void main(String[] args) {
        new swing_13_key_event();
    }
}
