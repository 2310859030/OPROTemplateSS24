package org.lecture.room;

import org.lecture.ColorHelper;
import org.lecture.player.Player;
import java.util.Random;
import java.util.Scanner;

/**
 * represents the trap room in the game.
 * in this room, the player must solve a puzzle to avoid taking damage from a trap.
 */
public class TrapRoom implements Room {
    private Room nextRoom;

    /**
     * handles the logic when a player enters the trap room
     * the player must solve a puzzle to avoid taking damage. If the puzzle is solved incorrectly, the player loses health points.
     * @param player who has entered the trap room
     * @return true if the player survives the room, false if the player loses all health points.
     */
    @Override
    public boolean surviveRoom(Player player) {
        Random random = new Random();
        int damage = random.nextInt(20) + 1;
        int subNumber = random.nextInt(damage) + 1;


        System.out.println(ColorHelper.TRAP + "You triggered a trap! Solve the puzzle to avoid damage!");
        System.out.println(ColorHelper.TRAP + "What is " + damage + " - " + subNumber + " : ");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        scanner.nextLine();

        if (answer == damage - subNumber) {
            System.out.println(ColorHelper.TRAP + "Luck you have" + ColorHelper.RESET);
        } else {
            System.out.println(ColorHelper.TRAP + "Trap! You loose 5 points" + ColorHelper.RESET);
            player.decreaseHealth(5);
            if (player.getPoints() <= 0) {
                System.out.println(ColorHelper.TRAP + "You have died." + ColorHelper.RESET);
                return false;
            }
        }
        return true;
    }
    @Override
    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    @Override
    public Room getNextRoom() {
        return nextRoom;
    }
}
