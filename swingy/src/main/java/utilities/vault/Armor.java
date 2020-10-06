package utilities.vault;

import java.util.Random;
import utilities.characters.Hero;

public class Armor {

    public int defense;

    public Armor(Hero hero) {
        Random rand = new Random();
        this.defense = (hero.getLevel() + 1) * 10 - (rand.nextInt(5) + 1);
    }

    public Armor(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}