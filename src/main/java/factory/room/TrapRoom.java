package factory.room;

import org.lecture.ColorHelper;
import player.Player;

import java.util.Random;
import java.util.Scanner;

public class TrapRoom implements Room {
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
}
