package factory.room;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RoomFactory {

    public List<Room> createRooms (int totalRooms) {
        if (totalRooms < 5) {
            throw new IllegalArgumentException("There must be at least 5 rooms, incl. Start- and EndRoom.");
        }

        List<Room> rooms = new ArrayList<>();
        rooms.add(new StartRoom());

        for (int i = 1; i < totalRooms -1; i++) {
            rooms.add(createRandomRoom());
        }

        rooms.add(new EndRoom());
        return rooms;
    }

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

