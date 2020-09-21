package utilities.characters;

import java.util.ArrayList;
import java.util.Scanner;

public class Hero extends Character {

	private int mapLimit;

    private String type;
    private int level = 0;
    private int experience = 0;

    //private Helm helmet;
   // private Armor armor;
    //private Weapon weapon;

    private int previousX;
    private int previousY;

    private final int MAX_LEVEL = 1;
	
	public int getLevel() {
		
		return level;
	}

	public void setMapLimit(int mapLimit) {
		this.mapLimit = mapLimit;
	}

	public void setCharacterPosition(int i, int j) {
		this.previousX = j;
        this.previousY = i;
        this.setX(j);
        this.setY(i);
	}

	public boolean move() {
		Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println();
        //TODO: ignore case may not need both checks (i.e ignore case "s" includes "S" and "s"

        setPreviousPosition(this.getX(), this.getY());

        if (input.equalsIgnoreCase("w")) {
            if (this.getY() != 0)
                this.setY(this.getY() - 1);
        } else if (input.equalsIgnoreCase("a")) {
            if (this.getX() != 0)
                this.setX(this.getX() - 1);
        } else if (input.equalsIgnoreCase("s")) {
            if (this.getY() != mapLimit - 1)
                this.setY(this.getY() + 1);
        } else if (input.equalsIgnoreCase("d")) {
            if (this.getX() != mapLimit - 1)
                this.setX(this.getX() + 1);
        } else if (input.equalsIgnoreCase("z")) {
            printAttributes();
        } else if (input.equalsIgnoreCase("x")) {
            printKey();
        } else if (input.equalsIgnoreCase("c")) {
            printControls();
        } else if (input.equalsIgnoreCase("q")) {
            return false;
        }
        return true;
	}

	private void printControls() {
		System.out.println("\nControls");
        System.out.println("--------");
        System.out.println("W - Up");
        System.out.println("A - Left");
        System.out.println("S - Down");
        System.out.println("D - Right");
        System.out.println();
        System.out.println("Q - Main Menu");
        System.out.println("Z - Hero Attributes");
        System.out.println("X - Map Key");
        System.out.println("C - Controls");
        System.out.println();
	}

	public void printKey() {
		System.out.println("\nMap Key");
        System.out.println("-------");
        System.out.println("o - Hero");
        System.out.println("x - Villain");
        System.out.println(". - Empty");
        System.out.println();
	}

	public void printAttributes() {
		System.out.println("\nCharacter Stats");
        System.out.println("---------------");
        System.out.println("Name:       " + this.getName());
       // System.out.println("Class:      " + this.getType());
        System.out.println("Level:      " + this.getLevel());
        //System.out.println("Experience: " + this.getExperience());
        System.out.println("Attack:     " + this.getAttack());
        System.out.println("Defense:    " + this.getDefense());
        System.out.println("Hit Points: " + this.getHitPoints());
        System.out.println();

        System.out.println("Character Artifacts");
        System.out.println("-------------------");
       // System.out.println("Helmet:     +" + this.helmet.getHitPoints() + " Hit Points");
       // System.out.println("Armor:      +" + this.armor.getDefense() + " Defense");
       // System.out.println("Weapon:     +" + this.weapon.getAttack() + " Attack");
        System.out.println();
	}

	private void setPreviousPosition(int x, int y) {
		this.previousX = x;
        this.previousY = y;
	}

	public ArrayList<String> saveAttributes() {
		ArrayList<String> list = new ArrayList<>();

        list.add(this.getName());
        list.add(this.getType());
        list.add(Integer.toString(this.getLevel()));
        //list.add(Integer.toString(this.getExperience()));
        list.add(Integer.toString(this.getAttack()));
        list.add(Integer.toString(this.getDefense()));
        list.add(Integer.toString(this.getHitPoints()));
        //list.add(Integer.toString(helmet.getHitPoints()));
        //list.add(Integer.toString(armor.getDefense()));
        //list.add(Integer.toString(weapon.getAttack()));

        return list;
	}

	  public void increaseExperience() {
        this.experience += ((this.level + 1) * 100);

        double total = (this.level * 1000) + (Math.pow((this.level - 1), 2) * 450);
        if  (this.experience > total) {
            if (this.level < MAX_LEVEL) {
                this.level++;
                this.experience -= total;
            }
            else
                this.experience = 0;
        }
	}
	
	public void levelUp() {
        if (this.level < MAX_LEVEL )
        this.level++;
	}
	
	public int getExperience() {
		return experience;
	}

	public String getType() {
		return type;
	}
}
