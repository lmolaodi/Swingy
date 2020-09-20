package view;

import javax.swing.JFrame;

import utilities.SwitchView;

public class SwitchViewFrame {

    private SwitchView switchViewGui;
    private JFrame frame;

    public SwitchViewFrame()
    {
        initialiseView();
    }

    public void initialiseView()
    {
        frame = new JFrame();

        switchViewGui = new SwitchView();

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(switchViewGui);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
