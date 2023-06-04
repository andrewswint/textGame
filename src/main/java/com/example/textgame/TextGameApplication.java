package com.example.textgame;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TextGameApplication {

    Scanner scanner = new Scanner(System.in);
    int fullHealth;
    int playerHealth;
    String weaponName;
    String item;

    public static void main(String[] args) {

        TextGameApplication game = new TextGameApplication();
        game.playerSetup();

        game.townGate();

    }

    public void playerSetup() {

        String playerName;
        System.out.println("What is your name?");
        playerName = scanner.nextLine();
        System.out.println("Nice to meet you " + playerName + ". Lets start your adventure...");

        fullHealth = 10;
        playerHealth = 10;
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
                System.out.println("\n------------------------------------\n");
                System.out.println("That's not a number!");
                System.out.println("\n------------------------------------\n");
                System.out.println(gateOptions);
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("\n------------------------------------\n");
                System.out.println("Guard: Greetings stranger, I'm sorry but I cannot allow strangers into the town.\n" +
                        "If you defeat the monster of the forest our town leaders would be ever grateful. I am sure you would be rewarded");
                System.out.println("\n------------------------------------\n");
                System.out.println(gateOptions);
                scanner.next();
            } else if (choice == 2) {
                playerHealth = playerHealth - 1;
                System.out.println("\n------------------------------------\n");
                System.out.println("The guard easily dodges your attack and throws you back... \n" +
                        "You receive 1 damage...\n" +
                        "Your HP is now " + playerHealth + "/" + fullHealth);
                System.out.println("\n------------------------------------\n");
                System.out.println(gateOptions);
            } else if (choice == 3) {
                valid = true;
                System.out.println("\n------------------------------------\n");
                System.out.println("You turn around and walk North");
                System.out.println("\n------------------------------------\n");
                crossroads();
            } else {
                System.out.println("\n------------------------------------\n");
                System.out.println("That is not a valid choice... \n" + gateOptions);
                System.out.println("\n------------------------------------\n");
            }
        } while (!valid);

    }

    public void crossroads() {

        System.out.println("\n------------------------------------\n");
        System.out.println("You find yourself at a crossroads...");
        System.out.println("\n------------------------------------\n");

        String crossroadsOption = "What direction do you go? \n" +
                "1. Go North?\n" +
                "2. Go East?\n" +
                "3. Go South?\n" +
                "4. Go West?";
        System.out.println(crossroadsOption);

        int choice;
        boolean valid = false;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("\n------------------------------------\n");
                System.out.println("That's not a number!");
                System.out.println("\n------------------------------------\n");
                System.out.println(crossroadsOption);
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice == 1) {
                valid = true;
                goNorth();
            } else if (choice == 2) {
                valid = true;
                goEast();
            } else if (choice == 3) {
                valid = true;
                townGate();
            }
            else if (choice == 4) {
                valid = true;
                goWest();
            } else {
                System.out.println("\n------------------------------------\n");
                System.out.println("That is not a valid choice... \n" + crossroadsOption);
                System.out.println("\n------------------------------------\n");
            }
        } while (!valid);

    }

    public void goNorth() {

        playerHealth = fullHealth;
        System.out.println("\n------------------------------------\n");

        System.out.println("You find a river you cannot cross. You drink from the river to restore your health.\n" +
                "Your HP is " + playerHealth + "/" + fullHealth + "\n" +
                "After resting by the river you return to the crossroads...");
        crossroads();

    }

    public void goEast() {

        item = "Magic sword";
        System.out.println("\n------------------------------------\n");
        System.out.println("You walk into the forest. While walking on the path you find a " + item + "!");
        String equipItem = "Would you like to equip the item? \n" +
                "y/N";
        System.out.println(equipItem);

        String choice;
        boolean valid = false;
        do {
            while (!scanner.hasNext()) {
                System.out.println("\n------------------------------------\n");
                System.out.println("That's not a number!");
                System.out.println("\n------------------------------------\n");
                System.out.println(equipItem);
                scanner.next();
            }
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                valid = true;
                weaponName = item;
                System.out.println("\n------------------------------------\n");
                System.out.println("Your weapon is now the " + weaponName + ".\n" +
                        "You turn around and head back to the crossroads.");
                crossroads();
            } else if (choice.equalsIgnoreCase("n")) {
                valid = true;
                System.out.println("\n------------------------------------\n");
                System.out.println("You turn around and head back to the crossroads leaving the " + item + ".\n" +
                        "Your weapon remains the " + weaponName + ".");
                crossroads();
            } else {
                System.out.println("\n------------------------------------\n");
                System.out.println("That is not a valid choice... \n" + equipItem);
            }
        } while (!valid);

    }

    public void goWest() {

        System.out.println("You find yourself face to face with the monster of the forest");


    }

}
