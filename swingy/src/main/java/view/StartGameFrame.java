package view;

import javax.swing.JFrame;

import utilities.characters.Hero;

public class StartGameFrame extends JFrame {

    private StartGame startGame;
    private Hero hero;

    public StartGameFrame(Hero hero) {
        this.hero = hero;
        initialiseView();

    }

    public void initialiseView() {
        this.dispose();
        startGame = new StartGame(hero);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(startGame);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}