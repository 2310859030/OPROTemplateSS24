package org.lecture;

import org.lecture.room.Room;
import org.lecture.room.RoomFactory;
import org.lecture.player.FileReaderPlayer;
import org.lecture.player.Player;
import java.util.List;

/**
 * Class to run the game logic.
 * This class loads the player, creates rooms, and manages the player's journey through the rooms.
 */
public class Game {

    private final Player player;
    private final List<Room> rooms;

    /**
     * initializes the game with the specified number of rooms
     * @param totalRooms total number of rooms
     */
    public Game(int totalRooms) {
        this.player = FileReaderPlayer.loadFromCSV("src/main/resources/Player.csv");
        this.rooms = new RoomFactory().createRooms(totalRooms);
    }

    /**
     * starts the game and manages the player's journey through the rooms.
     */
    public void start() {
        System.out.println("Player Name: " + player.getName());
        System.out.println("Max Health Points: " + player.getMaxHealthPoints());

        boolean alive = true;
        Room currentRoom = rooms.getFirst();
        while (currentRoom != null) {
            alive = currentRoom.surviveRoom(player);
            if (!alive) {
                System.out.println(ColorHelper.GRAVEYARD + Player.getGraveyard() + ColorHelper.RESET);
                System.out.println(ColorHelper.GRAVEYARD + player.getName() + " has died" + ColorHelper.RESET);
                break;
            }
            System.out.println(ColorHelper.SYSTEM + player.getName() + " has survived in " + currentRoom.getClass().getSimpleName());
            System.out.println(ColorHelper.SYSTEM + "Onto the next adventure...!" + ColorHelper.RESET);
            currentRoom = currentRoom.getNextRoom();
        }

        if (alive && player.getMaxHealthPoints() >= 10) {
            System.out.println(ColorHelper.FIREWORK + "Congratulations to " + player.getName() + ColorHelper.RESET);
            System.out.println(ColorHelper.FIREWORK + Player.getFireworks() + ColorHelper.RESET);
        } else if (alive) {
            System.out.println(ColorHelper.SYSTEM + player.getName() + " has survived the game!" + ColorHelper.RESET);
        }
    }
}


