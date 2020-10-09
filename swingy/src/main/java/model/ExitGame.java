package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.GuiFrame;

public class ExitGame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ext) {
        // TODO Auto-generated method stub
        closeGui();
    }

    public static void closeGui() {
        System.exit(0);
        // mainMenu();
    }
}