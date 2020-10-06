package view;

import javax.swing.JFrame;

public class SavedDataFrame extends JFrame {

    private LoadSavedData loadGui;
    
    public SavedDataFrame()
    {
        initialiseView();
    }

    public void initialiseView()
    {
        this.dispose();
        loadGui = new LoadSavedData();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(loadGui);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
