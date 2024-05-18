package org.lecture.npc;

import org.lecture.ColorHelper;

/**
 * represents a villager character in the game.
 */
public class Villager extends Person {

    /**
     * outputs a message from the villager.
     */
    @Override
    public void speak() {
        System.out.println(ColorHelper.ORDINARYROOM + "Villager: Hier am Land ist doch zu ruhig." + ColorHelper.RESET);
    }
}
