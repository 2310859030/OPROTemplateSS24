package org.lecture;

import java.util.Scanner;

/**
 * Driver class to start the game.
 * This class initializes the game with user input and starts it.
 */
public class GameDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a total number of rooms - min. 5: ");
        int totalRooms = scanner.nextInt();
        scanner.nextLine();

        Game game = new Game(totalRooms);
        game.start();
    }
}

