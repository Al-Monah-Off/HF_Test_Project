package gui;

import javax.swing.*;
import java.awt.*;

public class SwingTests {
    public static void main(String[] args) {
        SwingTests tests =new SwingTests();
        tests.go();
    }
    public void go(){
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JButton button = new JButton("Shock me!");
        JButton button1 = new JButton("bliss");
        JButton button2 = new JButton("huh?");


        panel.add(button);
        panel.add(button1);
        panel.add(button2);

        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,250);
        frame.setVisible(true);

    }
}
