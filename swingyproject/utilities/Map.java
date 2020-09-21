package utilities;

import java.util.Random;

import utilities.characters.Empty;
import utilities.characters.Hero;
import utilities.characters.Villain;

public class Map {

    private int size;
    private Character[][] map;
    private Random rand = new Random();
    private Hero hero;

    public Map(Hero hero) {
        this.size = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
        this.hero = hero;
        map = new Character[size][size];
        hero.setMapLimit((hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2));
        createMap();
    }

    private void createMap() {

        int i;
        int j;

        i = 0;
        j = 0;
        while (i < size)
        {
            while (j < size)
            {
                createGrid(j, i);
                j++;
            }
            i++;
        }
        hero.setCharacterPosition(size / 2, size / 2);
    }

    private void createGrid(int x, int y) {
        //Create Villain depending on outcome of random, or place empty slot
        int placeVillain = rand.nextInt(5) + 1;
        if (placeVillain != 1 && placeVillain != 2) {
            if ((x == size / 2) && (y == size / 2)) // Initial position of hero is on top of a hero resulting in a battle if no valid key is pressed
            {
                //map[y][x] = new Empty(".");
            } else if (x == 0) {
               // map[y][x] = new Villain("x ", hero);
            } else if (x == size - 1) {
                //map[y][x] = new Villain(" x", hero);
            } else {
               // map[y][x] = new Villain(" x ", hero);
            }
        } else {
            if (x == 0) {
               // map[y][x] = new Empty(". ");
            } else if (x == size - 1) {
                //map[y][x] = new Empty(" .");
            } else {
                //map[y][x] = new Empty(" . ");
            }
        }
    }

    public void displayMap()
    {
        int i;
        int j;

        j = 0;
        i = 0;
        while (i < size)
        {
            while (j < size)
            {
                if (hero.getX() == j && hero.getY() == i) {
                    if (j == 0) {
                        System.out.print("o ");
                    } else if (j == size - 1) {
                        System.out.print(" o");
                    } else {
                        System.out.print(" o ");
                    }
                    continue;
                }
                j++;
            }
            //System.out.print(map[i][j].getName());
            i++;
        }
        System.out.println();        
    }

    public int getSize() {
        return size;
    }

    public Character getCharacter(int y, int x) {
        return (map[y][x]);
    }

    public Hero getHero() {
        return hero;
    }

	public boolean battle() {
		return false;
	}

	public boolean victory() {
		return false;
	}

	public boolean checkHeroLevel() {
		return false;
	}
}
