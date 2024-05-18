package player;

import lombok.Getter;
import lombok.Setter;

public class Player {

    @Getter
    private String name;
    @Getter
    private int maxHealthPoints;
    @Setter
    private int points;

    public Player (String name, int maxHealthPoints) {
        setName(name);
        setMaxHealthPoints(maxHealthPoints);
    }

    public void setName(String name) {
        this.name = name.trim().isEmpty() ? "Default Name" : name.trim();
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints <= 0 ? 12 : maxHealthPoints;
    }

    public void addPoints(int points) {
        this.points += points;
    }

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

    public int getPoints() {
        return points;
    }

}
