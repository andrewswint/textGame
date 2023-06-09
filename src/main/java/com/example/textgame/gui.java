package com.example.textgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {

    JFrame window;
    Container container;
    JPanel titlePanel, startButtonPanel, storyPanel;
    JLabel titleLabel;
    JButton startButton;
    JTextArea storyText;

    TitleScreenHandler titleScreenHandler = new TitleScreenHandler();

    Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
    Font regularFont = new Font("Times New Roman", Font.PLAIN, 35);

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
        startButton.setFont(regularFont);
        startButtonPanel.add(startButton);
        startButton.addActionListener(titleScreenHandler);

        container.add(titlePanel);
        container.add(startButtonPanel);
        container.validate();

    }

    public void createGamePlayScreen() {

        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        storyPanel = new JPanel();
        storyPanel.setBounds(100,500,600,250);
        storyPanel.setBackground(Color.green);
        container.add(storyPanel);

        storyText = new JTextArea();
        storyText.setBounds(100,500,600,250);
        storyText.setBackground(Color.black);
        storyText.setForeground(Color.green);
        storyText.setFont(regularFont);
        storyText.setLineWrap(true);
        storyPanel.add(storyText);

        container.validate();

    }

    public class TitleScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            createGamePlayScreen();

        }
    }

}
