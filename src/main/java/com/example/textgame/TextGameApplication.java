package com.example.textgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TextGameApplication {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        TextGameApplication game = new TextGameApplication();
//        game.playerInfo();

        game.townGate();

    }

    public void playerInfo() {

        String playerName;
        System.out.println("What is your name?");
        playerName = scanner.nextLine();
        System.out.println("Nice to meet you " + playerName + ". Lets start your adventure...");

        int fullHealth;
        fullHealth = 10;

        int playerHealth;
        playerHealth = 10;

        String weaponName;
        weaponName = "Rusty knife";

        System.out.println("Your health: " + playerHealth + "/" + fullHealth);
        System.out.println("Your current weapon: " + weaponName);

        System.out.println("\n------------------------------------\n");

    }

    public void townGate() {

        System.out.println("You are standing outside the town gate... \n" +
                "There is a guard standing in your way... \n");

        String gateOptions = "What do you do? \n" +
                "1. Talk to the guard?\n" +
                "2. Attack the guard?\n" +
                "3. Go explore somewhere else?";
        System.out.println(gateOptions);

        int choice;
        boolean valid = false;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.println(gateOptions);
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice == 1) {
                valid = true;
                System.out.println("Talk to the guard");
            } else if (choice == 2) {
                valid = true;
                System.out.println("Attack the guard");
            } else if (choice == 3) {
                valid = true;
                System.out.println("Go explore somewhere else");
            } else {
                System.out.println("That is not a valid choice... \n" + gateOptions);
            }
        } while (!valid);
        System.out.println("Thank you! Got " + choice);

    }

}
