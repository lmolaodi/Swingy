package view;

import javax.swing.JFrame;

import model.CreateHero;

public class CreateHeroFrame extends JFrame {

    private CreateHero heroGui;

    public CreateHeroFrame() {

        initialiseView();
    }

    public void initialiseView() {
        heroGui = new CreateHero();

        this.setResizable(false);

        this.add(heroGui);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}