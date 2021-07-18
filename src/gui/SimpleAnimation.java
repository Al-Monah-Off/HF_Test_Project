package gui;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation  {

    JFrame frame;
    int x,y = 20;

    public static void main(String[] args) {
        SimpleAnimation simpleAnimation = new SimpleAnimation();
        simpleAnimation.go();
    }

    public void go() {
        frame = new JFrame("Animation App");

        DrawAnything draw = new DrawAnything();

        frame.getContentPane().add(BorderLayout.CENTER,draw);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocation(600,300);
        frame.setVisible(true);
        frame.setResizable(false);

        for (int i = 0; i < 130; i++,x++,y++) {
            draw.repaint();
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    class DrawAnything extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white);
            g2d.fillRect(0,0,this.getWidth(),this.getHeight());
            g2d.setColor(Color.BLACK);
            g2d.fillOval(x,y,100,100);

        }
    }

}
