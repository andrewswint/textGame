package com.example.textgame;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TextGameApplication {

    Scanner scanner = new Scanner(System.in);
    int playerFullHP;
    int playerHP;
    int monsterHP;
    int monsterFullHP;
    String weaponName;
    String item;
    int playerDamage;
    int monsterDamage;
    boolean chest = false;
    boolean goldTablet = false;

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

        playerFullHP = 10;
        playerHP = 10;
        monsterHP = 30;
        monsterFullHP = 30;
        weaponName = "Knife";

        System.out.println("Your health: " + playerHP + "/" + playerFullHP);
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
                if(goldTablet) {
                    System.out.println("Guard: You have returned with the lost gold tablet stolen by the monster of the forest! You must come in and show this to our elders");
                } else {
                    System.out.println("Guard: Greetings stranger, I'm sorry but I cannot allow strangers into the town.\n" +
                            "If you defeat the monster of the forest our town elders would be ever grateful.");
                    System.out.println("\n------------------------------------\n");
                    System.out.println(gateOptions);
                    scanner.next();
                }

            } else if (choice == 2) {
                playerHP = playerHP - 1;
                System.out.println("\n------------------------------------\n");
                System.out.println("The guard easily dodges your attack and throws you back... \n" +
                        "You receive 1 damage...\n" +
                        "Your HP is now " + playerHP + "/" + playerFullHP);
                System.out.println("\n------------------------------------\n");
                System.out.println(gateOptions);
            } else if (choice == 3) {
                valid = true;
                System.out.println("\n------------------------------------\n");
                System.out.println("You turn around and walk North");
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

        playerHP = playerFullHP;
        System.out.println("\n------------------------------------\n");

        System.out.println("You find a river you cannot cross. You drink from the river to restore your health.\n" +
                "Your HP is " + playerHP + "/" + playerFullHP + "\n" +
                "After resting by the river you return to the crossroads...");
        crossroads();

    }

    public void goEast() {

        item = "Sword";
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

        if (monsterHP < 1) {
            win();
        } else {
            System.out.println("\n------------------------------------\n");
            System.out.println("You find yourself face to face with the monster of the forest...");
            System.out.println("\n------------------------------------\n");

            String monsterOptions = "What do you do? \n" +
                    "1. Attack?\n" +
                    "2. Run?\n" +
                    "3. Hide?";
            System.out.println(monsterOptions);

            int choice;
            boolean valid = false;
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("\n------------------------------------\n");
                    System.out.println("That's not a number!");
                    System.out.println("\n------------------------------------\n");
                    System.out.println(monsterOptions);
                    scanner.next();
                }
                choice = scanner.nextInt();
                if (choice == 1) {
                    valid = true;
                    fight();
                } else if (choice == 2) {
                    valid = true;
                    crossroads();
                } else if (choice == 3) {
                    valid = true;
                    System.out.println("\n------------------------------------\n");
                    System.out.println("The monster finds you and attacks");
                    monsterDamage = 0;
                    monsterDamage = new java.util.Random().nextInt(5);
                    System.out.println("The monsters HP is now " + monsterHP + "/" + monsterFullHP);
                    playerHP = playerHP - monsterDamage;
                    if (playerHP > 0) {
                        System.out.println("The monster strikes back...\n" +
                                "Your HP is now " + playerHP + "/" + playerFullHP);
                        goWest();
                    } else {
                        dead();
                    }
                } else {
                    System.out.println("\n------------------------------------\n");
                    System.out.println("That is not a valid choice... \n" + monsterOptions);
                    System.out.println("\n------------------------------------\n");
                }
            } while (!valid);
        }

    }

    public void fight() {

        if(weaponName.equalsIgnoreCase("knife")) {
            playerDamage = new java.util.Random().nextInt(100);
        } else if(weaponName.equalsIgnoreCase("sword")) {
            playerDamage = new java.util.Random().nextInt(8);
        } else {
            weaponName = "hands";
            playerDamage = new java.util.Random().nextInt(2);
        }

        System.out.println("You attack the monster with your " + weaponName + " and delt " + playerDamage + " damage!");

        monsterHP = monsterHP - playerDamage;

        if(monsterHP < 1) {
            win();
        } else {
            monsterDamage = 0;
            monsterDamage = new java.util.Random().nextInt(8);
            System.out.println("The monsters HP is now " + monsterHP + "/" + monsterFullHP);
            playerHP = playerHP - monsterDamage;
            if (playerHP > 0) {
                System.out.println("The monster strikes back...\n" +
                        "Your HP is now " + playerHP + "/" + playerFullHP);
                goWest();
            } else {
                dead();
            }
        }
    }

    public void dead() {

        System.out.println("You have been defeated. \n" +
                "GAME OVER");

    }

    public void win() {

        chest = true;
        System.out.println("\n------------------------------------\n");
        System.out.println("You have defeated the monster\n" +
                "You find a chest behind the monster");
        String chestOption = "Do you open the chest? \n" +
                "y/N";

        System.out.println(chestOption);

        String choice;
        boolean valid = false;
        do {
            while (!scanner.hasNext()) {
                System.out.println("\n------------------------------------\n");
                System.out.println("That's not a number!");
                System.out.println("\n------------------------------------\n");
                System.out.println(chestOption);
                scanner.next();
            }
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                valid = true;
                goldTablet = true;
                System.out.println("\n------------------------------------\n");
                System.out.println("You open the chest to find a gold tablet with strange writing on it\n" +
                        "You should take the tablet back to town...\n" +
                        "You turn around and head back to the crossroads.");
                crossroads();
            } else if (choice.equalsIgnoreCase("n")) {
                valid = true;
                System.out.println("\n------------------------------------\n");
                System.out.println("You leave the chest alone and head back to the crossroads");
                crossroads();
            } else {
                System.out.println("\n------------------------------------\n");
                System.out.println("That is not a valid choice... \n" + chestOption);
            }
        } while (!valid);
    }

}
