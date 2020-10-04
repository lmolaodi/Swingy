package utilities;

import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utilities.characters.Hero;
import utilities.vault.Armor;
import utilities.vault.Helm;
import utilities.vault.Weapon;
import view.StartGame;

public class SelectArtifact extends JPanel {

    private Map map;
    private Hero hero;
    private Random rand;
    private Helm helm = null;
    private Armor armor = null;
    private Weapon weapon = null;
    private int arttifact;

    public SelectArtifact(Map map, Hero hero) {
        initComponents();
        this.map = map;
        this.hero = hero;
        rand = new Random();
        displayArtifact();
    }

    private void displayArtifact() {
        arttifact = rand.nextInt(3) + 1;
        if (arttifact == 1) {
            helm = new Helm(hero);
            artifactTextArea.setText(null);
            artifactTextArea.setText("New Helmet:");
            artifactTextArea.append("\n\nOld HP: " + hero.getHelmet().getHitPoints());
            artifactTextArea.append("\nNew HP: " + helm.getHitPoints());
        } else if (arttifact == 2) {
            armor = new Armor(hero);
            artifactTextArea.setText(null);
            artifactTextArea.setText("New Armor:");
            artifactTextArea.append("\n\nOld DEF: " + hero.getArmor().getDefense());
            artifactTextArea.append("\nNew DEF: " + armor.getDefense());
        } else if (arttifact == 3) {
            weapon = new Weapon(hero);
            artifactTextArea.setText(null);
            artifactTextArea.setText("New Weapon:");
            artifactTextArea.append("\n\nOld ATT: " + hero.getWeapon().getAttack());
            artifactTextArea.append("\nNew ATT: " + weapon.getAttack());
        }
    }

    private void initComponents() {

        equipButton = new javax.swing.JButton();
        declineButton = new javax.swing.JButton();
        artifactScrollPane = new javax.swing.JScrollPane();
        artifactTextArea = new javax.swing.JTextArea();

        equipButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        equipButton.setText("Equip");
        equipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipButtonActionPerformed(evt);
            }
        });

        declineButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        declineButton.setText("Decline");
        declineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 declineButtonActionPerformed(evt);
            }
        });

        artifactTextArea.setColumns(20);
        artifactTextArea.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        artifactTextArea.setRows(5);
        artifactScrollPane.setViewportView(artifactTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup().addContainerGap(75, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(equipButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(declineButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE))
                                .addGap(75, 75, 75))
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(artifactScrollPane)
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(artifactScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                        .addGap(18, 18, 18).addComponent(equipButton).addGap(18, 18, 18).addComponent(declineButton)
                        .addGap(31, 31, 31)));
    }

    protected void declineButtonActionPerformed(ActionEvent evt) {
        if (evt.getSource() == declineButton)
        {
            this.firePropertyChange("Decline", null, evt);
        }
    }

    protected void equipButtonActionPerformed(ActionEvent evt) {
        if (evt.getSource() == equipButton)
        {
            if (arttifact == 1)
            StartGame.setHelm(helm);
        else if (arttifact == 2)
            StartGame.setArmor(armor);
        else if (arttifact == 3)
            StartGame.setWeapon(weapon);
             this.firePropertyChange("Equip", null, evt);
        }
    }

    private javax.swing.JScrollPane artifactScrollPane;
    private javax.swing.JTextArea artifactTextArea;
    private javax.swing.JButton declineButton;
    private javax.swing.JButton equipButton;
}
