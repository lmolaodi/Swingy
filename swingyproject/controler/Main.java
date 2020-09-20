package controler;

import utilities.Map;
import utilities.characters.Hero;
import view.GuiFrame;

public class Main {
    private static Hero hero = null;
    //private static Map map;
    private static GuiFrame guiView = null;
    public static void main(String[] args) {
        if (args.length == 0) {
            changeViewGui();
        } else if (args.length == 1) {
            if (args[0].equals("console")) {
                //mainMenu();
            } else if (args[0].equals("gui")) {
                changeViewGui();
            }
        }
    }
    
    private static void changeViewGui() {
        guiView = new GuiFrame();
    }

    private static void startGame()
    {
        if (hero == null)
        {
            System.out.println("\n No hero selected.. Please select a hero.\n");
            //selectCharacter();
        }
    }
}
