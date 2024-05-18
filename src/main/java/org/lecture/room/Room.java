package org.lecture.room;

import org.lecture.player.Player;

/**
 * represents a room that a player can encounter
 * each room has his own logic for the player to survive it
 */

public interface Room {

   /**
    * defines the logic for the player to survive the room.
    * @param player who is trying to survive the room.
    * @return A boolean indicating whether the player survives the room.
    */
   boolean surviveRoom(Player player);

   void setNextRoom(Room nextRoom);

   Room getNextRoom();
}
