package Inheritance.npc;

import org.lecture.ColorHelper;

public class Farmer extends Person {

    @Override
    public void speak() {
        System.out.println(ColorHelper.ORDINARYROOM + "Farmer: Die Ernte wird heuer gut werden." + ColorHelper.RESET);
    }
}
