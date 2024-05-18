package factory.room;

import org.lecture.ColorHelper;
import player.Player;

public class StartRoom implements Room {
    @Override
    public boolean surviveRoom(Player player) {
        System.out.println(ColorHelper.STARTROOM + "Player " + player.getName() + " has entered the game. Onwards the journey goes...!" + ColorHelper.RESET);
        return true;
    }
}
