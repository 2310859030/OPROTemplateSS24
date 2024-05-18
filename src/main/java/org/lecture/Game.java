package org.lecture;

import factory.room.Room;
import factory.room.RoomFactory;
import player.FileReaderPlayer;
import player.Player;

import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a total number of rooms - min. 5: ");
        int totalRooms = scanner.nextInt();
        scanner.nextLine();

        Player player = FileReaderPlayer.loadFromCSV("src/main/resources/Player.csv");
        List<Room> rooms = new RoomFactory().createRooms(totalRooms);

        System.out.println("Player Name: " + player.getName());
        System.out.println("Max Health Points: " + player.getMaxHealthPoints());

        boolean alive = true;
        for (Room room : rooms) {
            alive = room.surviveRoom(player);
            if (!alive) {
                System.out.println(ColorHelper.GRAVEYARD + Player.getGraveyard() + ColorHelper.RESET);
                System.out.println(ColorHelper.GRAVEYARD + player.getName() + " has died" + ColorHelper.RESET);
                break;
            }
            System.out.println(ColorHelper.SYSTEM + player.getName() + " has survived in " + room.getClass().getSimpleName());
            System.out.println(ColorHelper.SYSTEM + "Onto the next adventure...!" + ColorHelper.RESET);
        }

        if (alive && player.getMaxHealthPoints() >= 10) {
            System.out.println(ColorHelper.FIREWORK + "Congratulations to " + player.getName() + ColorHelper.RESET);
            System.out.println(ColorHelper.FIREWORK + Player.getFireworks() + ColorHelper.RESET);
        } else if (alive) {
            System.out.println(ColorHelper.SYSTEM + player.getName() + " has survived the game!" + ColorHelper.RESET);
        }
    }
}



