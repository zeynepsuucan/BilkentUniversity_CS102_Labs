import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class Panel {

    public static void main(String[] args) {


        JFrame frame = new JFrame("Stick Figure:");
        JPanel panel = new JPanel();
        StickFigure man = new StickFigure(500,500,Color.red,500);

        man.createButtons(panel);
        frame.add(panel);
        frame.add(man);
        panel.setSize(200,200);
        panel.setLocation(0,0);
        frame.setVisible(true);
        frame.setSize(900,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    

}