package view;

import javax.swing.JFrame;

import utilities.characters.Hero;

public class StartGameFrame {
    private StartGame startGame;
    private JFrame frame;
    private Hero hero;

    public StartGameFrame()
    {
        initialiseView();
        this.hero = hero;
    }

    public void initialiseView()
    {
        frame = new JFrame();

        startGame = new StartGame(hero);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(startGame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
