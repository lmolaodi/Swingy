package view;

import javax.swing.JFrame;

import utilities.CreateHero;

public class CreateHeroFrame {

    private CreateHero heroGui;
    private JFrame frame;

    public CreateHeroFrame()
    {
        initialiseView();
    }

    public void initialiseView()
    {
        frame = new JFrame();

        heroGui = new CreateHero();

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(heroGui);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
