import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class MyWindow extends JFrame{
 
    JButton win, metal, motif;

    public MyWindow() {

        JPanel toolbar = new JPanel();
        JPanel demobar = new JPanel();

        demobar.add(new JButton("Copy"));
        demobar.add(new JButton("Cut"));
        demobar.add(new JButton("Paste"));

        win = new JButton("Windows");
        metal = new JButton("Metal");
        motif = new JButton("Motif");

        LnFListener lnf = new LnFListener(this);

        win.addActionListener(lnf);
        metal.addActionListener(lnf);
        motif.addActionListener(lnf);
    
        toolbar.add(win);
        toolbar.add(metal);
        toolbar.add(motif);

        this.add(toolbar, BorderLayout.SOUTH);
        this.add(demobar, BorderLayout.NORTH);
        this.setTitle("PLAF");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    class LnFListener implements ActionListener{
        JFrame f;

        LnFListener(JFrame f) {
            this.f = f;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            String lnf;
            if(e.getSource() == win){
                lnf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            } else if(e.getSource() == metal){
                lnf = "javax.swing.plaf.metal.MetalLookAndFeel";
            } else {
                lnf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            }
            
            try{
                UIManager.setLookAndFeel(lnf);
                SwingUtilities.updateComponentTreeUI(f);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}


public class swing_11_plaf {
    public static void main(String[] args) {
        new MyWindow();   
    }
}
