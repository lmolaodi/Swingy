package view;

import javax.swing.JFrame;

import view.SwitchView;

public class SwitchViewFrame extends JFrame{

    private SwitchView switchViewGui;

    public SwitchViewFrame()
    {
    
        initialiseView();
    }

    public void initialiseView()
    {
        switchViewGui = new SwitchView();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(switchViewGui);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
