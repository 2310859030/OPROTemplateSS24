package Inheritance.npc;

import org.lecture.ColorHelper;

public class Villager extends Person {

    @Override
    public void speak() {
        System.out.println(ColorHelper.ORDINARYROOM + "Villager: Hier am Land ist doch zu ruhig." + ColorHelper.RESET);
    }
}
