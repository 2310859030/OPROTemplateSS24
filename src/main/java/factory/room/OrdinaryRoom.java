package factory.room;

import Inheritance.npc.Farmer;
import Inheritance.npc.Person;
import Inheritance.npc.Villager;
import org.lecture.ColorHelper;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdinaryRoom implements Room {
    private final List<Person> people = new ArrayList<>();

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

    @Override
    public boolean surviveRoom(Player player) {
        System.out.println(ColorHelper.ORDINARYROOM + "Welcome to the Ordinary Room" + ColorHelper.RESET);
        for (Person person : people) {
            person.speak();
        }
        return true;
    }
}
