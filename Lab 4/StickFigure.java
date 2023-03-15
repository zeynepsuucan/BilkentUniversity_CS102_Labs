import java.awt.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StickFigure extends JPanel{
    
    private int baseX; // center of the figure
    private int baseY; // bottom of the feet
    private Color color; // color of the figure
    private int height; // height of the figure
    private int headW; // width of the head
    private int legLength; // length of the legs
    private int legPosition;// # pixels the legs are up from vertical
    private int armLength; // horizontal length of the arms
    private int armToFloor; // distance from base to arms
    private int armPosition;// # pixels arm is above/below horizontal
    int PANEL_WIDTH = 900;
    Timer t;
    JSlider slider;
    boolean move;
    boolean moveB;

    JPanel panel = new JPanel();

    //
    JCheckBox eye;
    JCheckBox mouth;
    JCheckBox arms;
    JCheckBox face;
    
    public StickFigure(int center, int bottom, Color shade, int size) { 
        baseX = center;
        baseY = bottom;
        color = shade;
        height = size;
        headW = height / 5;
        legLength = height / 2;
        armToFloor = 2 * height / 3;
        armLength = height / 3;
        // set initial position of arms and legs
        armPosition = -20;
        legPosition = 15;
        setPreferredSize (new Dimension(320, 200));
        // define body positions proportional to height
        final int DELAY = 10;
        t = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(move == true)
                move(1,0);
                if(moveB == true)
                move(-1,0);


                repaint();
            }
        });
        t.start();
  
    }

    
    public void paintComponent(Graphics page) {
       
       //super.paintComponent(page);
       page.clearRect(300, 0, 100000, 100000);
        int top = baseY - height;
        page.setColor(color);
        // draw the head
        if(face.isSelected()){
        page.drawOval(baseX - headW / 2, top, headW, headW);
        repaint();
        }
        // draw the trunk
        page.drawLine(baseX, top + headW, baseX, baseY - legLength);
        // draw the legs
        page.drawLine(baseX, baseY - legLength, baseX - legPosition, baseY);
        page.drawLine(baseX, baseY - legLength, baseX + legPosition, baseY);
       
        // draw the arms
        if(arms.isSelected()){
        int startY = baseY - armToFloor;
        page.drawLine(baseX, startY, baseX - armLength, startY - armPosition);
        page.drawLine(baseX, startY, baseX + armLength, startY - armPosition);
        repaint();
        }

        if(mouth.isSelected()){
        page.drawRect(baseX - headW/4, top + 70, headW/2, headW/8);
        repaint();
        }

        if(eye.isSelected()){ 
        page.drawOval(baseX - headW / 4, top + 30, headW/8, headW/8);
        page.drawOval(baseX + headW / 4, top + 30, headW/8, headW/8);
        repaint();
        }

    }

    public void createButtons(JPanel panel){
        JButton stop = new JButton("STOP");
        stop.setForeground(Color.black);
        stop.setBounds(50, 50, 50, 50);
        ActionListener b = new ClickListener2();
        stop.addActionListener(b);
        panel.add(stop);
        //stop.addActionListener(l);
        
        JButton move = new JButton("MOVE");
        move.setBounds(50, 50, 50, 50);
        move.setForeground(Color.black);
        ActionListener a = new ClickListener();
        move.addActionListener(a);
        panel.add(move,BorderLayout.SOUTH);

        JButton moveBack = new JButton("MOVE BACK");
        moveBack.setBounds(50, 50, 50, 50);
        moveBack.setForeground(Color.black);
        ActionListener f = new ClickListener6();
        moveBack.addActionListener(f);
        panel.add(moveBack,BorderLayout.SOUTH);

        JButton black = new JButton("black");
        black.setBounds(50, 50, 50, 50);
        black.setForeground(Color.black);
        ActionListener c = new ClickListener3();
        black.addActionListener(c);
        panel.add(black,BorderLayout.SOUTH);

        JButton cyan = new JButton("cyan");
        cyan.setBounds(50, 50, 50, 50);
        cyan.setForeground(Color.cyan);
        ActionListener d = new ClickListener4();
        cyan.addActionListener(d);
        panel.add(cyan,BorderLayout.SOUTH);

        JButton red= new JButton("red");
        red.setBounds(50, 50, 50, 50);
        red.setForeground(Color.red);
        ActionListener e = new ClickListener5();
        red.addActionListener(e);
        panel.add(red,BorderLayout.SOUTH);


        ChangeListener change = new SChanger();
        slider = new JSlider(JSlider.HORIZONTAL, -100 , 100, 0);
        slider.addChangeListener(change);
        panel.add(slider);

        eye = new JCheckBox("Eye?");
        panel.add(eye);
        
        mouth = new JCheckBox("Mouth?");
        panel.add(mouth);

        arms = new JCheckBox("Arms?");
        panel.add(arms);

        face = new JCheckBox("Face?");
        panel.add(face);
    }

    public class SChanger implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
           
           height += slider.getValue();
           repaint();
            
        }
    }

    public class ClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move(1,0); 
            move = true;
            moveB = false;
            t.start();
        }
    }
    public class ClickListener6 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move(-1,0); 
            moveB = true;
            move = false;
            t.start();
        }
    }

    public class ClickListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t.stop(); 
        }
    }


    public class ClickListener3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            color = Color.black;
            repaint();
        }
    }


    public class ClickListener4 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            color = Color.CYAN;
            repaint();
        }
    }
    public class ClickListener5 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            color = Color.red;
            repaint();
        }
    }


    public void move(int over, int down) {
        if(baseX >= 900){
            baseX = 405;
        }

        if(baseX <= 400){
            baseX = 900;
        }
        baseX += over;
        baseY += down;
        repaint();

    }

    public void grow(double factor) {
        height = (int) (factor * height);
        // reset body parts proportional to new height
        headW = height / 5;
        legLength = height / 2;
        armToFloor = 2 * height / 3;
        armLength = height / 3;
    }

    public void setLegPosition(int newPosition) {
        legPosition = newPosition;
    }

    public void setArmPosition(int newPos) {
        armPosition = newPos;
    }

    
}