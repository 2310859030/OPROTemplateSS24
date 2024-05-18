package org.lecture.player;

import lombok.Getter;
import lombok.Setter;

/**
 * represents a player in the game
 * player has a name, maximum health points, and points that can be increased or decreased
 */
@Getter
public class Player {

    private String name;
    private int maxHealthPoints;
    @Setter
    private int points;

    /**
     * constructs a new player with the specified name and maximum health points
     * @param name of the player
     * @param maxHealthPoints of the player
     */
    public Player (String name, int maxHealthPoints) {
        setName(name);
        setMaxHealthPoints(maxHealthPoints);
    }
    /**
     * sets the name of the player.
     * if the name is empty or only whitespace, sets the name to "Default Name".
     * @param name of the player
     */
    public void setName(String name) {
        this.name = name.trim().isEmpty() ? "Default Name" : name.trim();
    }

    /**
     * sets the maximum health points of the player
     * if the maximum health points is less than or equal to 0, sets it to 12
     * @param maxHealthPoints of the player
     */
    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints <= 0 ? 12 : maxHealthPoints;
    }

    /**
     * adds points to the player's current points
     * @param points to add
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * decreases the player's health points by the specified damage
     * @param damage amount of damage to decrease
     */
    public void decreaseHealth(int damage) {
        maxHealthPoints -= damage;
    }

    public static String getGraveyard() {
        return """
                ,-=-.       ______     _
                /  +  \\     />----->  _|1|_
                | ~~~ |    // -/- /  |_ H _|
                |R.I.P|   //  /  /     |S|
                \\vV,,|_____|V,//_____/VvV,v,|_|/,,vhjwv/,
                """;
    }

    public static String getFireworks() {
        return """


                                                     .''.
                           .''.             *''*    :_\\/_:     .
                          :_\\/_:   .    .:.*_\\/_*   : /\\ :  .'.:.'.
                      .''.: /\\ : _\\(/_  ':'* /\\ *  : '..'.  -=:o:=-
                     :_\\/_:'.:::. /)\\*''*  .|.* '.\\'/.'_\\(/_'.':'.'
                     : /\\ : :::::  '*_\\/_* | |  -= o =- /)\\    '  *
                      '..'  ':::'   * /\\ * |'|  .'/.\\'.  '._____
                          *        __*..* |  |     :      |.   |' .---"|
                           _*   .-'   '-. |  |     .--'|  ||   | _|    |
                        .-'|  _.|  |    ||   '-__  |   |  |    ||      |
                        |' | |.    |    ||       | |   |  |    ||      |
                     ___|  '-'     '    ""       '-'   '-.'    '`      |____
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                        
                    ------------------------------------------------
                    """;
    }

}
