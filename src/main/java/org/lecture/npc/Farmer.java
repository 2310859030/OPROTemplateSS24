package org.lecture.npc;

import org.lecture.ColorHelper;

/**
 * represents a farmer character in the game.
 */

public class Farmer extends Person {

    /**
     * outputs a message from the farmer
     */
    @Override
    public void speak() {
        System.out.println(ColorHelper.ORDINARYROOM + "Farmer: Die Ernte wird heuer gut werden." + ColorHelper.RESET);
    }
}
