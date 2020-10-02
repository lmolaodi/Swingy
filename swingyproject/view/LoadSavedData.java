package view;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utilities.characters.Hero;

public class LoadSavedData extends JPanel {

    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane heroInfoScrollPanel;
    private javax.swing.JTextArea heroInfoTextArea;
    private javax.swing.JButton loadButton;
    private javax.swing.JComboBox<String> loadCharacterComboBox;

    private ArrayList<String> list;
    private File[] listOfFiles = null;
    private static Hero hero = null;
    private boolean validFile = false;

    public LoadSavedData() {
        initializeView();
        addItems();
    }
    
    private void addItems() {
        //        ArrayList<String> list = new ArrayList<>();
        try {
            
            String fileName = System.getProperty("user.dir") + "/swingyproject/saves/";
            File folder = new File(fileName);
            listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                loadCharacterComboBox.addItem(file.getName());
            }
        } catch (Exception e) {
            loadButton.doClick();
        }
    }

    public static Hero getHero() {
        return hero;
    }

    private void initializeView() {
        backButton = new javax.swing.JButton();
        loadCharacterComboBox = new javax.swing.JComboBox<>();
        heroInfoScrollPanel = new javax.swing.JScrollPane();
        heroInfoTextArea = new javax.swing.JTextArea();
        loadButton = new javax.swing.JButton();

        backButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        backButton.setText("Back");
        backButton.setMaximumSize(new java.awt.Dimension(165, 30));
        backButton.setMinimumSize(new java.awt.Dimension(165, 30));
        backButton.setPreferredSize(new java.awt.Dimension(165, 30));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 backButtonActionPerformed(evt);
            }
        });

        loadCharacterComboBox.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        loadCharacterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Hero" }));
        loadCharacterComboBox.setMaximumSize(new java.awt.Dimension(400, 30));
        loadCharacterComboBox.setMinimumSize(new java.awt.Dimension(400, 30));
        loadCharacterComboBox.setPreferredSize(new java.awt.Dimension(400, 30));
        loadCharacterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadCharacterComboBoxActionPerformed(evt);
            }
        });

        heroInfoTextArea.setColumns(20);
        heroInfoTextArea.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        heroInfoTextArea.setRows(5);
        heroInfoScrollPanel.setViewportView(heroInfoTextArea);

        loadButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        loadButton.setText("Load");
        loadButton.setMaximumSize(new java.awt.Dimension(165, 30));
        loadButton.setMinimumSize(new java.awt.Dimension(165, 30));
        loadButton.setPreferredSize(new java.awt.Dimension(165, 30));
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 loadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(150, 150, 150)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(heroInfoScrollPanel).addComponent(loadCharacterComboBox,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 400,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup().addGap(275, 275, 275)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(150, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(80, 80, 80)
                        .addComponent(loadCharacterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(heroInfoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18).addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)));
    }

    protected void backButtonActionPerformed(ActionEvent evt) {
        this.firePropertyChange("Back", null, evt);
    }

    protected void loadButtonActionPerformed(ActionEvent evt) {
        if (loadCharacterComboBox.getSelectedItem() == "Select Hero") {
            this.firePropertyChange("Default", null, evt);
        } else {
            if (validFile = false) {
                this.firePropertyChange("NoFile", null, evt);
            } else {
                hero = new Hero(list);
                this.firePropertyChange("Load", null, evt);
            }
        }
    }

    protected void loadCharacterComboBoxActionPerformed(ActionEvent evt) {
         heroInfoTextArea.setText(null);
        String fileName;
        File file = null;

        try {
            if (!(loadCharacterComboBox.getSelectedItem() == "Select Hero")) {
                fileName = System.getProperty("user.dir")
                        + "/swingyproject/saves/"
                        + loadCharacterComboBox.getSelectedItem();
                list = new ArrayList<>();
                try {
                    file = new File(fileName);
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        list.add(line);
                    }
                    reader.close();
                } catch (IOException e) {
                    System.out.println("\nThat file does not exist.");
                }

                heroInfoTextArea.setText(
                        "Hero Attributes\n"
                                + "- - - - - - - - "
                                + "\nName:   " + list.get(0)
                                + "\nClass:  " + list.get(1)
                                + "\nLevel:  " + list.get(2)
                                + "\nEXP:    " + list.get(3)
                                + "\nATT:    " + list.get(4)
                                + "\nDEF:    " + list.get(5)
                                + "\nHP:     " + list.get(6)
                                + "\n\nHero Artifacts"
                                + "\n- - - - - - - -"
                                + "\nHelmet: " + list.get(7) + " HP"
                                + "\nArmor:  " + list.get(8) + " DEF"
                                + "\nWeapon: " + list.get(9) + " ATT\n"
                );
            }
        } catch (Exception E) {
            loadCharacterComboBox.hidePopup();
            if (file != null) {
                file.delete();
                loadCharacterComboBox.removeItem(loadCharacterComboBox.getSelectedItem());
            }
            JOptionPane.showMessageDialog(null, "Incorrect File Format. File has been removed",
                    "WARNING", JOptionPane.ERROR_MESSAGE);
        }
    }
}
