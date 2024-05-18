package factory.room;

import org.lecture.ColorHelper;
import player.Player;

import java.util.Random;

public class Tavern implements Room {
    @Override
    public boolean surviveRoom(Player player) {
        Random random = new Random();
        int playerRoll = random.nextInt(20) + 1;
        int opponentRoll = random.nextInt(20) + 1;

        System.out.println(ColorHelper.TAVERN + player.getName() + " enters the Tavern 'The prancing pony. \nYou must participate in a dice game. If you roll a number less than your opponent Mr Underberg, \nyou must drink dwarve's beer and lose 3 health points" + ColorHelper.RESET);
        System.out.println(ColorHelper.TAVERN + player.getName() + "Rolling dice...");
        System.out.println(ColorHelper.TAVERN + "Your result: " + playerRoll + ColorHelper.RESET);
        System.out.println(ColorHelper.TAVERN + "Opponent rolls their dice...");
        System.out.println(ColorHelper.TAVERN + "Opponent's result: " + opponentRoll + ColorHelper.RESET);

        if (playerRoll < opponentRoll) {
            System.out.println(ColorHelper.TAVERN + "You loose. Deducting 3 healthpoints." + ColorHelper.RESET);
            player.decreaseHealth(3);
            if (player.getPoints() <= 0) {
                System.out.println( ColorHelper.TAVERN + player.getName() + " has died from drinking too much dwarve's beer!" + ColorHelper.RESET);
                return false;
            }
        } else {
            System.out.println(ColorHelper.TAVERN + "You win!" + ColorHelper.RESET);
        }
        return true;
    }
}
