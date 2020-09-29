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
        JFrame frame = new JFrame();
        switchViewGui = new SwitchView();

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(switchViewGui);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
