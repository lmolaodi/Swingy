package view;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.Main;
import view.SwitchViewFrame;
import view.LoadSavedData;

public class Gui extends javax.swing.JPanel{
        
        JPanel jPanel1 = new javax.swing.JPanel();
        JLabel Title = new javax.swing.JLabel();
        JButton startButton = new javax.swing.JButton();
        JButton loadButton = new javax.swing.JButton();
        JButton switchViewButton = new javax.swing.JButton();
        JButton exitButton = new javax.swing.JButton();
        JButton createButton = new javax.swing.JButton();
        JLabel versionLabel = new javax.swing.JLabel();
        
        public Gui() {
                initComponents();
        }
        
        private void initComponents() {
                
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
                        );
                        jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 100, Short.MAX_VALUE)
                                );
                                
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
                                loadButton.setText("Load Game");
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
                                                // exitButtonActionPerformed(evt);
                                        }
                                });
                                
                                versionLabel.setFont(new java.awt.Font("Courier", 0, 12));
                                versionLabel.setText("v1.1");
                                
                                createButton.setFont(new java.awt.Font("Courier", 0, 13));
                                createButton.setText("Create");
                                createButton.setMaximumSize(new java.awt.Dimension(165, 30));
                                createButton.setMinimumSize(new java.awt.Dimension(165, 30));
                                createButton.setPreferredSize(new java.awt.Dimension(165, 30));
                                createButton.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                //  createButtonActionPerformed(evt);
                                        }
                                });
                                
                                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                                this.setLayout(layout);
                                layout.setHorizontalGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                        .addGap(275, 275, 275)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(switchViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(175, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(175, 175, 175))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(versionLabel)
                                        .addContainerGap())))
                                        );
                                        
                                        layout.setVerticalGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(switchViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(versionLabel)
                                                .addContainerGap())
                                                );
                                        }
                                        
                                        protected void loadButtonActionPerformed(ActionEvent evt) {

                                                SavedDataFrame view = new SavedDataFrame();
                                                view.initialiseView();
                                        }

                                        protected void startGameButtonActionPerformed(ActionEvent evt) {
                                                if (evt.getSource() == startButton)
                                                {
                                                        CreateHeroFrame view = new CreateHeroFrame();
                                                        view.initialiseView();
                                                }
                                        }

                                        protected void switchViewButtonActionPerformed(ActionEvent evt) {
                                                if (evt.getSource() == switchViewButton)
                                                {
                                                        
                                                        SwitchViewFrame view = new SwitchViewFrame();
                                                        view.initialiseView();
                                                        GuiFrame cls = new GuiFrame();
                                                        cls.closeFrame();
                                                }
                                        }
                                }
