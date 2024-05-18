package org.lecture.room;

import org.lecture.ColorHelper;
import org.lecture.player.Player;

/**
 * represents the start room of the game.
 * this is the first room a player enters when the game begins.
 */

public class StartRoom implements Room {
private Room nextRoom;
    /**
     * Handles the logic when a player enters the start room.
     * @param player who has entered the room
     * @return s always true as the player successfully starts the game.
     */
    @Override
    public boolean surviveRoom(Player player) {
        System.out.println(ColorHelper.STARTROOM + "Player " + player.getName() + " has entered the game. Onwards the journey goes...!" + ColorHelper.RESET);
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
