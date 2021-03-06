package model;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class Battle extends JPanel {

    public Battle() {
        initComponents();
    }

    private void initComponents() {

        fightButton = new javax.swing.JButton();
        runButton = new javax.swing.JButton();

        fightButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        fightButton.setText("Fight");
        fightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fightButtonActionPerformed(evt);
            }
        });

        runButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap(75, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fightButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(runButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(22, 22, 22)
                        .addComponent(fightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18).addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE)));
    }

    protected void runButtonActionPerformed(ActionEvent evt) {
        if (evt.getSource() == runButton) {
            this.firePropertyChange("Run", null, evt);
        }
    }

    protected void fightButtonActionPerformed(ActionEvent evt) {
        if (evt.getSource() == fightButton) {
            this.firePropertyChange("Fight", null, evt);
        }
    }

    private javax.swing.JButton fightButton;
    private javax.swing.JButton runButton;
}