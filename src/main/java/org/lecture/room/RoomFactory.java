package org.lecture.room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * factory class for creating rooms in the game.
 * ensures that a sequence of rooms includes a start room, an end room, and various random rooms in between.
 */
public class RoomFactory {

    /**
     * creates a list of rooms for the game.
     * the list includes a StartRoom, an EndRoom, and various random rooms in between.
     * @param totalRooms number of rooms to create. Must be at least 5.
     * @return A list of rooms for the game.
     * @throws IllegalArgumentException if the total number of rooms is less than 5.
     */
    public List<Room> createRooms (int totalRooms) {
        if (totalRooms < 5) {
            throw new IllegalArgumentException("There must be at least 5 rooms, incl. Start- and EndRoom.");
        }

        List<Room> rooms = new ArrayList<>();
        Room previousRoom = new StartRoom();
        rooms.add(new StartRoom());

        for (int i = 1; i < totalRooms -1; i++) {
            Room currentRoom = createRandomRoom();
            previousRoom.setNextRoom(currentRoom);
            rooms.add(currentRoom);
            previousRoom = currentRoom;
        }

        Room endRoom = new EndRoom();
        previousRoom.setNextRoom(endRoom);
        rooms.add(endRoom);

        return rooms;
    }
    /**
     * creates a random room.
     * the type of room created depends on a random number.
     * @return s a randomly selected room.
     */

    private Room createRandomRoom() {
        int randomNumber = ThreadLocalRandom.current().nextInt(1,22);
        if (randomNumber % 5 == 0) {
            return new MagicRoom();
        } else if (randomNumber % 4 == 0) {
            return new Tavern();
        } else if (randomNumber % 3 == 0) {
            return new OrdinaryRoom();
        } else {
            return new TrapRoom();
        }
    }
}

