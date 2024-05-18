package org.lecture.room;

import org.lecture.ColorHelper;
import org.lecture.player.Player;

/**
 *represents the endroom of the game
 * once the player reached this room, the journey has come to an end
 */
public class EndRoom implements Room {
    private Room nextRoom;

    /**
     * handles the logic once the player reaches the endroom
     * @param player who has reached the endroom
     * @return s always true as the player successfully reaches the end of the game
     */
    @Override
    public boolean surviveRoom(Player player) {
        System.out.println(ColorHelper.ENDROOM + player.getName() + " has reached the journey's end");
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
