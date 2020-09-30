package view;

import javax.swing.JFrame;

import utilities.CreateHero;

public class CreateHeroFrame extends JFrame{

    private CreateHero heroGui;

    public CreateHeroFrame()
    {
        this.dispose();
        initialiseView();
    }
    public void initialiseView()
    {
        
        heroGui = new CreateHero();
        this.dispose();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(heroGui);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
