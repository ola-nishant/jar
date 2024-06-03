import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

// introduction to swing in java
// swing is a part of java foundation classes (JFC) that is used to create window-based applications.
// swing is a lightweight component that has no reliance on the native code and the applications are consistent across all platforms.
// They are executed by the java run-time environment and work on all platforms that support java.

class swing_01_jframe {
    public static void main(String[] args) {
        
        // First, we create a JFrame object 
        // JFrame is a top-level container that represents the main window of a GUI
        // application. It provides a title bar, and minimizes, maximizes, and closes
        // buttons.
        JFrame frame = new JFrame("My First Swing Application");
        
        // adding components to the frame
        JButton btn_1 = new JButton("Click Me");
        JLabel lbl_1 = new JLabel("Hello World");
        
        // setting the position of the button and label
        btn_1.setBounds(40, 40, 100, 40);
        lbl_1.setBounds(40, 80, 100, 40);

        frame.add(btn_1);
        frame.add(lbl_1);

        frame.setLayout(null);
        frame.setSize(400, 400);
        frame.setVisible(true);

        // to prevent resizing of the frame
        // frame.setResizable(false);
        
        // set the icon of the frame
        ImageIcon icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());

        // to set the background color of the frame
        frame.getContentPane().setBackground(new ColorUIResource(198, 179, 130));

        // to close the application when the close button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}