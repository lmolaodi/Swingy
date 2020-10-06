package view;

import javax.swing.JFrame;

public class SwitchViewFrame extends JFrame {

    private SwitchView switchViewGui;

    public SwitchViewFrame() {
        this.dispose();
        initialiseView();
    }

    public void initialiseView() {
        switchViewGui = new SwitchView();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(switchViewGui);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}