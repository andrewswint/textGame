package com.example.textgame;

import javax.swing.*;
import java.awt.*;

public class gui {

    JFrame window = new JFrame();

    public static void main(String[] args) {
        gui gui = new gui();
        gui.game();
    }

    public void game() {

        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);


    }
}
