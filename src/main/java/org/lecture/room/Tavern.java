package org.lecture.room;

import org.lecture.ColorHelper;
import org.lecture.player.Player;
import java.util.Random;

/**
 * represents the tavern room in the game.
 * in this room, the player must participate in a dice game against an opponent.
 */
public class Tavern implements Room {
    private Room nextRoom;

    /**
     * handles the logic when a player enters the tavern room.
     * the player participates in a dice game and may lose health points if they lose the game.
     * @param player who has entered the tavern room.
     * @return true if the player survives the room, false if the player loses all health points.
     */
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
    @Override
    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    @Override
    public Room getNextRoom() {
        return nextRoom;
    }
}
