package gui;

import javax.swing.*;
import java.awt.*;

public class Swing2TextField {
    public static void main(String[] args) {
        Swing2TextField swing2 = new Swing2TextField();
        swing2.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel,BoxLayout.LINE_AXIS));

        JTextField textField = new JTextField("Enter your name",20);

        JLabel label = new JLabel("Your name: ");
        Font font = new Font(Font.SERIF,20,20);
        label.setFont(font);
        label.setForeground(Color.yellow);
        panel.add(label);
        panel.add(textField);
        textField.selectAll();
        textField.requestFocus();



        frame.getContentPane().add(BorderLayout.NORTH,panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,250);
        frame.setVisible(true);

    }
}
