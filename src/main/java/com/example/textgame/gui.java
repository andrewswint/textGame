package com.example.textgame;

import javax.swing.*;
import java.awt.*;

public class gui {

    JFrame window;
    Container container;
    JPanel titlePanel, startButtonPanel;
    JLabel titleLabel;
    JButton startButton;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 35);

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
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("Forest Adventure");
        titleLabel.setForeground(Color.green);
        titleLabel.setFont(titleFont);
        titlePanel.add(titleLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("Begin");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.green);
        startButton.setFont(buttonFont);
        startButtonPanel.add(startButton);

        container.add(titlePanel);
        container.add(startButtonPanel);
        container.validate();

    }
}
