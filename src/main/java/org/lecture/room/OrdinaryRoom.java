package org.lecture.room;

import org.lecture.npc.Farmer;
import org.lecture.npc.Person;
import org.lecture.npc.Villager;
import org.lecture.ColorHelper;
import org.lecture.player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * handles the logic of the Ordinary room
 * the player encounters a number of people in the room and has to define the numbers ob villagers
 */
public class OrdinaryRoom implements Room {
    private Room nextRoom;
    private final List<Person> people = new ArrayList<>();

    /**
     * constructs an ordinary room instance
     * force the user to specify the number of people and villagers in the room
     * throws an IllegalArgumentException if the number of villagers exceeds the number of people
     */
    public OrdinaryRoom() {
        System.out.println("How many people are in the room?:");
        Scanner scanner = new Scanner(System.in);
        int totalPeople = scanner.nextInt();
        scanner.nextLine();
        System.out.println("How many Villagers are in the room?:");
        int numberOfVillagers = scanner.nextInt();
        scanner.nextLine();

        if (numberOfVillagers > totalPeople) {
            throw new IllegalArgumentException(ColorHelper.ORDINARYROOM + "Number of villagers cannot be more than Number of people in the room!" + ColorHelper.RESET);
        }

        for (int i = 0; i < totalPeople; i++) {
            if (i < numberOfVillagers) {
                people.add(new Villager());
            } else {
                people.add(new Farmer());
            }
        }

    }

    /**
     * handles the logic when the player enters the room
     * each person speaks to the player
     * @param player who has entered the room
     * @return s always true as the player successfully completes the room
     */

    @Override
    public boolean surviveRoom(Player player) {
        System.out.println(ColorHelper.ORDINARYROOM + "Welcome to the Ordinary Room" + ColorHelper.RESET);
        for (Person person : people) {
            person.speak();
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
