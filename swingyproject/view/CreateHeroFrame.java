package view;

import javax.swing.JFrame;

import utilities.CreateHero;
import view.GuiFrame;

public class CreateHeroFrame extends JFrame{

    private CreateHero heroGui;

    public CreateHeroFrame()
    {
     
        initialiseView();
    }

    public void initialiseView()
    {
        this.dispose();
        heroGui = new CreateHero();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.add(heroGui);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
