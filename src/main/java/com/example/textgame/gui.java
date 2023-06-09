package com.example.textgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {

    int playerFullHP;
    int playerHP;

    String weaponName;

    JFrame window;
    Container container;
    JPanel titlePanel, startButtonPanel, storyPanel, choiceButtonPanel, playerInfoPanel;
    JLabel titleLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    JButton startButton, choice1, choice2, choice3, choice4;
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
        window.setSize(800,800);
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
        startButtonPanel.setBounds(300,500,200,100);
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

        playerInfoPanel = new JPanel();
        playerInfoPanel.setBounds(50,50,600,150);
        playerInfoPanel.setBackground(Color.black);
        playerInfoPanel.setLayout(new GridLayout(1,4));


        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(regularFont);
        hpLabel.setForeground(Color.green);
        playerInfoPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(regularFont);
        hpLabelNumber.setForeground(Color.green);
        playerInfoPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(regularFont);
        weaponLabel.setForeground(Color.green);
        playerInfoPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(regularFont);
        weaponLabelName.setForeground(Color.green);
        playerInfoPanel.add(weaponLabelName);
        container.add(playerInfoPanel);
        container.add(playerInfoPanel);

        storyPanel = new JPanel();
        storyPanel.setBounds(100,200,600,250);
        storyPanel.setBackground(Color.black);
        container.add(storyPanel);

        storyText = new JTextArea("This is the story and more and more and more and more and more");
        storyText.setBounds(100,100,600,400);
        storyText.setBackground(Color.black);
        storyText.setForeground(Color.green);
        storyText.setFont(regularFont);
        storyText.setLineWrap(true);
        storyPanel.add(storyText);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,550,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        container.add(choiceButtonPanel);

        choice1 = new JButton("choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.green);
        choice1.setFont(regularFont);
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.green);
        choice2.setFont(regularFont);
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.green);
        choice3.setFont(regularFont);
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.green);
        choice4.setFont(regularFont);
        choiceButtonPanel.add(choice4);

        playerSetup();

        container.validate();

    }

    public void playerSetup() {
        playerFullHP = 10;
        playerHP = 10;
        weaponName = "Knife";

        hpLabelNumber.setText(playerHP + "/" + playerFullHP);

        weaponLabelName.setText(weaponName);
    }

    public class TitleScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            createGamePlayScreen();

        }
    }

}
