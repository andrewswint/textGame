package com.example.textgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TextGameApplication {

    public static void main(String[] args) {

        String myWeapon;
        int myHp;

        System.out.println("What is your name...");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        System.out.println("Nice to meet you " + playerName);



    }

}
