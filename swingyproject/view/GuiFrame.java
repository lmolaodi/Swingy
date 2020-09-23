package view;

import java.util.Map;
import view.Gui;
import javax.swing.JFrame;
import view.SwitchViewFrame;

import utilities.characters.Hero;

public class GuiFrame  extends JFrame{
    private Gui gui;
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
        gui = new Gui();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(gui);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
   /* private void newSwitchView() {
        SwitchViewFrame switchView = new SwitchViewFrame();
        switchView.addPropertyChangeListener(new SwitchViewListener());

        //frame.add(switchView);
        frame.pack();
    }*/
}
