package model.vault;

import java.util.Random;
import model.characters.Hero;

public class Helm {

    private int hitPoints;

    public Helm(Hero hero) {
        Random rand = new Random();
        this.hitPoints = (hero.getLevel() + 1) * 10 - (rand.nextInt(5) + 1);
    }

    public Helm(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}