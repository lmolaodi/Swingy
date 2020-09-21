package utilities;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import utilities.characters.Hero;

public class CreateHero extends JPanel{

    private Hero hero;
    private String name;
    private String classType;

    public CreateHero(){
        createHeroGui();
        this.hero = null;
        this.name = null;
        this.classType = null;
    }

    public void createHeroGui() {
        
        JButton CreateButton = new JButton();
        JButton backButton = new JButton();
        JTextField heroNameField = new JTextField();
        JComboBox selectClassComboBox = new JComboBox<>();
        JTextArea heroInfoArea = new JTextArea();
        JLabel nameLabel = new JLabel();

        CreateButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        CreateButton.setText("Create");
        CreateButton.setMaximumSize(new java.awt.Dimension(165, 30));
        CreateButton.setMinimumSize(new java.awt.Dimension(165, 30));
        CreateButton.setPreferredSize(new java.awt.Dimension(165, 30));
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //CreateButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        backButton.setText("Back");
        backButton.setMaximumSize(new java.awt.Dimension(165, 30));
        backButton.setMinimumSize(new java.awt.Dimension(165, 30));
        backButton.setPreferredSize(new java.awt.Dimension(165, 30));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // backButtonActionPerformed(evt);
            }
        });

        heroNameField.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        heroNameField.setToolTipText("Press Enter to apply name.");
        heroNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // heroNameFieldActionPerformed(evt);
            }
        });

        selectClassComboBox.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        selectClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Class", "Warrior", "Archer" }));
        selectClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // selectClassComboBoxActionPerformed(evt);
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
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(heroInfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heroNameField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectClassComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(275, 275, 275))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heroNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(heroInfoArea, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
    }
}
