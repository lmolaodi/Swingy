package model;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.App;
import view.StartGameFrame;
import model.characters.Hero;
import view.StartGame;

public class CreateHero extends JPanel {
    
    private static Hero hero;
    private String name;
    private String type;

    /**
     * Creates new form CreateCharacter
     */
    public CreateHero() {
        initComponents();
        hero = null;
        name = null;
        type = null;
    }

    public static Hero getHero() {
        return hero;
    }

    private void initComponents() {

        CreateButton = new JButton();
        backButton = new JButton();
        heroNameField = new JTextField();
        selectClassComboBox = new JComboBox<>();
        heroInfoArea = new JTextArea();
        nameLabel = new JLabel();

        CreateButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        CreateButton.setText("Create");
        CreateButton.setMaximumSize(new java.awt.Dimension(165, 30));
        CreateButton.setMinimumSize(new java.awt.Dimension(165, 30));
        CreateButton.setPreferredSize(new java.awt.Dimension(165, 30));
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (name == null) {
                    JOptionPane.showMessageDialog(null, "Please enter Warrior name then Press Enter!");
                } else if (name.length() < 3 || name.length() > 8) {
                    JOptionPane.showMessageDialog(null, "Warrior name must be 4 - 8 characters!..");
                } else {

                    if (selectClassComboBox.getSelectedItem() == "Select Class") {
                        JOptionPane.showMessageDialog(null, "Select warrior classtype");
                    } else if (type == null) {
                        JOptionPane.showMessageDialog(null, "Select warrior classtype");
                    } else {

                        hero = new Hero(name, type);
                        JOptionPane.showMessageDialog(null, "Load complete!!....");
                        loadStartGameActionPerformed(evt);
                    }
                }
            }
        });

        backButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        backButton.setText("Back");
        backButton.setMaximumSize(new java.awt.Dimension(165, 30));
        backButton.setMinimumSize(new java.awt.Dimension(165, 30));
        backButton.setPreferredSize(new java.awt.Dimension(165, 30));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                App.changeViewGui();
            }
        });

        heroNameField.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        heroNameField.setToolTipText("Press Enter to apply name.");
        heroNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heroNameFieldActionPerformed(evt);
            }
        });

        selectClassComboBox.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        selectClassComboBox
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Class", "Warrior", "Archer" }));
        selectClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectClassComboBoxActionPerformed(evt);
            }
        });

        heroInfoArea.setColumns(20);
        heroInfoArea.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        heroInfoArea.setRows(5);
        heroInfoArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        nameLabel.setText("Enter Hero Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addGap(275, 275, 275)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(heroInfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(heroNameField, javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                                        selectClassComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(275, 275, 275)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addGap(110, 110, 110).addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heroNameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(selectClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(heroInfoArea, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18).addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)));
    }

    protected void loadStartGameActionPerformed(ActionEvent evt) {
        this.firePropertyChange("Load", null, evt);
        this.firePropertyChange("Start Game", null, evt);
    }

    private void selectClassComboBoxActionPerformed(java.awt.event.ActionEvent evt) {

        heroInfoArea.setText(null);
        if (selectClassComboBox.getSelectedItem() == "Warrior") {
            heroInfoArea.setText("Base Attributes:\n\n");
            heroInfoArea.append("DEF: +20\n");
            heroInfoArea.append("HP : +50\n");
            type = "Warrior";
            heroInfoArea.append("\n");
            heroInfoArea.append("Name: " + name + "\n");
        } else if (selectClassComboBox.getSelectedItem() == "Archer") {
            heroInfoArea.setText("Base Attributes:\n\n");
            heroInfoArea.append("ATT: +20");
            type = "Archer";
            heroInfoArea.append("\n");
            heroInfoArea.append("Name: " + name + "\n");
        }
    }

    private void heroNameFieldActionPerformed(java.awt.event.ActionEvent evt) {

        name = heroNameField.getText();
        // System.out.println(name);
    }

    private javax.swing.JButton CreateButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea heroInfoArea;
    private javax.swing.JTextField heroNameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox<String> selectClassComboBox;
}