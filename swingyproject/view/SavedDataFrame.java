package view;

import javax.swing.JFrame;
import view.LoadSavedData;

public class SavedDataFrame extends JFrame {

    private LoadSavedData loadGui;
    
    public SavedDataFrame()
    {
        this.dispose();
        initialiseView();
    }

    public void initialiseView()
    {
        loadGui = new LoadSavedData();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(loadGui);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
