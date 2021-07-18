package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI1 {
    JFrame frame;
    JButton colorButton;
    JButton labelButton;
    MyDrawPanel myDrawPanel;
    JLabel label;
    int x,y = 20;

    public static void main(String[] args) {
        SimpleGUI1 gui = new SimpleGUI1();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        colorButton = new JButton("Change circle");
        labelButton = new JButton("Change label");
        label = new JLabel("I`m a label");
        colorButton.addActionListener(new ColorListener());
        labelButton.addActionListener(new LabelListener());
        myDrawPanel = new MyDrawPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER,myDrawPanel);
        frame.getContentPane().add(BorderLayout.WEST,label);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Ouch!");
        }
    }
    class ColorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }
    class MyDrawPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            int red = (int)(Math.random() * 255);
            int green = (int)(Math.random() * 255);
            int blue = (int)(Math.random() * 255);
            Color startColor = new Color(red,green,blue);

            red = (int)(Math.random() * 255);
            green = (int)(Math.random() * 255);
            blue = (int)(Math.random() * 255);
            Color endColor = new Color(red,green,blue);

            GradientPaint gradientPaint = new GradientPaint(x,y,startColor,x+70,y+70,endColor);
            g2d.setPaint(gradientPaint);
            g2d.fillOval(x,y,100,100);
        }
    }
}

