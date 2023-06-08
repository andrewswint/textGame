package com.example.textgame;

import javax.swing.*;
import java.awt.*;

public class gui {

    JFrame window;
    Container container;
    JPanel titlePanel;
    JLabel titleLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);

    public static void main(String[] args) {
        gui gui = new gui();
        gui.game();
    }

    public void game() {

        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        container = window.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.green);
        titleLabel = new JLabel("Forest Adventure");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);
        titlePanel.add(titleLabel);
        container.add(titlePanel);
        container.validate();

    }
}
