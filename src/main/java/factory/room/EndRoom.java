package factory.room;

import org.lecture.ColorHelper;
import player.Player;

public class EndRoom implements Room {
    @Override
    public boolean surviveRoom(Player player) {
        System.out.println(ColorHelper.ENDROOM + player.getName() + " has reached the journey's end");
        return true;
    }
}
