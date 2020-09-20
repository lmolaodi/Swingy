package utilities.characters;

public class Hero extends Character {

	private int mapLimit;

    private String type;
    private int level = 0;
    private int experience = 0;

    //private Helm helmet;
    //private Armor armor;
    //private Weapon weapon;

    private int previousX;
	private int previousY;
	
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
}
