package view;

import java.awt.event.ActionEvent;

import controller.App;

public class SwitchView extends javax.swing.JPanel {

    public SwitchView() {
        callSwitchGui();
    }

    private javax.swing.JButton backButton;
    private javax.swing.JButton loadConsoleButton;

    public void callSwitchGui() {
        backButton = new javax.swing.JButton();
        loadConsoleButton = new javax.swing.JButton();

        backButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        backButton.setText("Back");
        backButton.setMaximumSize(new java.awt.Dimension(165, 30));
        backButton.setMinimumSize(new java.awt.Dimension(165, 30));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        loadConsoleButton.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        loadConsoleButton.setText("Console View");
        loadConsoleButton.setMaximumSize(new java.awt.Dimension(165, 30));
        loadConsoleButton.setMinimumSize(new java.awt.Dimension(165, 30));
        loadConsoleButton.setPreferredSize(new java.awt.Dimension(165, 30));
        loadConsoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               consoleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap(275, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(loadConsoleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(275, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap(177, Short.MAX_VALUE)
                        .addComponent(loadConsoleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104).addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)));
    }

    protected void consoleButtonActionPerformed(ActionEvent evt) {
        this.firePropertyChange("Console View", null, evt);
    }

    protected void backButtonActionPerformed(ActionEvent evt) {
        this.firePropertyChange("Back", null, evt);
    }
}