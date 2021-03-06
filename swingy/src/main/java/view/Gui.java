package view;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.App;
import view.LoadSavedData;

public class Gui extends javax.swing.JPanel {

        JPanel jPanel1 = new JPanel();
        JLabel Title = new JLabel();
        JButton startButton = new JButton();
        JButton loadButton = new JButton();
        JButton switchViewButton = new JButton();
        JButton exitButton = new JButton();
        JButton createButton = new JButton();
        JLabel versionLabel = new JLabel();

        public Gui() {

                initComponents();
        }

        private void initComponents() {

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
                                                100, Short.MAX_VALUE));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
                                                100, Short.MAX_VALUE));

                Title.setFont(new java.awt.Font("Courier", 0, 95));
                Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                Title.setText("Swingy");
                Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                startButton.setFont(new java.awt.Font("Courier", 0, 13));
                startButton.setText("Start Game");
                startButton.setMaximumSize(new java.awt.Dimension(165, 30));
                startButton.setMinimumSize(new java.awt.Dimension(165, 30));
                startButton.setPreferredSize(new java.awt.Dimension(165, 30));
                startButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                startGameButtonActionPerformed(evt);
                        }
                });

                loadButton.setFont(new java.awt.Font("Courier", 0, 13));
                loadButton.setText("Continue");
                loadButton.setMaximumSize(new java.awt.Dimension(165, 30));
                loadButton.setMinimumSize(new java.awt.Dimension(165, 30));
                loadButton.setPreferredSize(new java.awt.Dimension(165, 30));
                loadButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loadButtonActionPerformed(evt);
                        }
                });

                switchViewButton.setFont(new java.awt.Font("Courier", 0, 13));
                switchViewButton.setText("Change Display");
                switchViewButton.setMaximumSize(new java.awt.Dimension(165, 30));
                switchViewButton.setMinimumSize(new java.awt.Dimension(165, 30));
                switchViewButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                switchViewButtonActionPerformed(evt);
                        }
                });

                exitButton.setFont(new java.awt.Font("Courier", 0, 13));
                exitButton.setText("Exit Game");
                exitButton.setMaximumSize(new java.awt.Dimension(165, 30));
                exitButton.setMinimumSize(new java.awt.Dimension(165, 30));
                exitButton.setPreferredSize(new java.awt.Dimension(165, 30));
                exitButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                System.exit(0);
                        }
                });

                versionLabel.setFont(new java.awt.Font("Courier", 0, 12));
                versionLabel.setText("v1.1");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(275, 275, 275).addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(loadButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(switchViewButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                .addComponent(startButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(175, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                                .addComponent(Title,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                350,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(175, 175, 175))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                                .addComponent(versionLabel)
                                                                                                .addContainerGap()))));

                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap()
                                                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 167,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34,
                                                                Short.MAX_VALUE)
                                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)

                                                .addGap(18, 18, 18)
                                                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(switchViewButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42).addComponent(versionLabel).addContainerGap()));
        }

        protected void loadButtonActionPerformed(ActionEvent evt) {
                this.firePropertyChange("Continue", null, evt);
        }

        protected void startGameButtonActionPerformed(ActionEvent evt) {
                this.firePropertyChange("Start Game", null, evt);
        }

        protected void switchViewButtonActionPerformed(ActionEvent evt) {
                this.firePropertyChange("Change Display", null, evt);
        }
}