package view;

import controller.App;
import model.Map;
import model.characters.Hero;

public class ConsoleView {
    
    private Map map = null;
    private Hero hero = null;
    private boolean gameOn = true;

    public ConsoleView(Map map, Hero hero) {
        this.map = map;
        this.hero = hero;
        
        System.out.println("Game Started.");
        System.out.println("Welcome to Swingy Text-based RPG Game!!!! \n");
        hero.printAttributes();
        System.out.println("To view controls press the 'c' key.");
        hero.printKey();

        startGame();
        App.setMap(this.map);
        App.setHero(this.hero);
        App.mainMenu();
    }

    public void startGame() {
        while (gameOn) {
            map.displayMap();
            System.out.println();

            if (!hero.move()) {
                gameOn = false;
            }

            if (!map.battle()) {
                gameOn = false;
            } else if (map.victory()) {
                if (map.checkHeroLevel())
                    gameOn = false;
                else
                    map = new Map(hero);
            }
        }
    }
}