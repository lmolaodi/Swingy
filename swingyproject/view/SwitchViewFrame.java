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

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(switchViewGui);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
