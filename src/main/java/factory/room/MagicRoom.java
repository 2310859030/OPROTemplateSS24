package factory.room;

import org.lecture.ColorHelper;
import player.Player;

import java.util.Scanner;

public class MagicRoom implements Room {
    public boolean surviveRoom(Player player) {
        System.out.println(ColorHelper.MAGICROOM + "A wizards shows up and demand you say a magic spell!");
        Scanner scanner = new Scanner(System.in);
        String spell = scanner.nextLine();
        if (spell.length() > 10) {
            System.out.println(ColorHelper.MAGICROOM + "Powerful magic! You get 5 points." + ColorHelper.RESET);
            player.addPoints(5);
        } else if (!spell.isEmpty()) {
            System.out.println(ColorHelper.MAGICROOM + "Next time cast a longer spell to truly own the throne! You still get 3 points." + ColorHelper.RESET);
        } else {
            System.out.println(ColorHelper.MAGICROOM + "Without a spell, the magic stays tame, next round, speak up to ignite the game!" + ColorHelper.RESET);
        }
        return true;
    }
}
