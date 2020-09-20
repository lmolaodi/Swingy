package view;

import java.util.Map;
import view.Gui;
import javax.swing.JFrame;

import utilities.characters.Hero;

public class GuiFrame {
    private Gui gui;
    private JFrame frame;
    private static Map map;
    private static Hero hero;
    
    public GuiFrame(){
        initialiseView();
    }

    public GuiFrame(Map map, Hero hero){

        this.map = map;
        this.hero = hero;
        initialiseView();
    }

    public void initialiseView()
    {
        frame = new JFrame();

        gui = new Gui();

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(gui);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
