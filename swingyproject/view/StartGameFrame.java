package view;

import javax.swing.JFrame;

import utilities.characters.Hero;

public class StartGameFrame extends JFrame{
    private StartGame startGame;
    private Hero hero;

    public StartGameFrame()
    {
        initialiseView();
        this.hero = hero;
    }

    public void initialiseView()
    {

        startGame = new StartGame(hero);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(startGame);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
